function formatDate(lastUpdated){
  var date = new Date(lastUpdated); //lastUpdated is a String
  var year = date.getFullYear();
  var month = ("0" + (date.getMonth() + 1)).slice(-2);  //january=0, so need to +1
  var day = ("0" + date.getDate()).slice(-2);
  var hour = ("0" + date.getHours()).slice(-2);
  var minute = ("0" + date.getMinutes()).slice(-2);
  var second = ("0" + date.getSeconds()).slice(-2);
  return `${year}-${month}-${day} ${hour}:${minute}:${second} HKT`;  //`` <-String indicator
}

$(document).ready(function(){
  setInterval(function(){
    $.ajax({
      url: '/refresh',
      type: 'GET',
      success: function(data){
        console.log(data);   //check webside:F12
        //assume data is a list
        data.forEach(function(coin,index){
          var row = $(`tr[data-coin-id='${coin.id}']`);
          if (row.length){
            row.find(".current-price").text("$" + coin.current_price.toFixed(2));  //use current_price, already calling js,   toFixed->decimal place
            row.find(".market-cap").text("$" + coin.market_cap);
            row.find(".last-update").text(formatDate(coin.last_updated));

            var priceClass = Math.abs(coin.price_change_percentage_24h).toFixed(2) == 0.00
            ? "neutral"
            : coin.price_change_percentage_24h < 0
            ? "down"
            : "up";

            var priceChangeIcon = Math.abs(coin.price_change_percentage_24h).toFixed(2) == 0.00
            ? ""
            :coin.price_change_percentage_24h < 0
            ? "▼"
            : "▲";

            var priceChangeValue = Math.abs(coin.price_change_percentage_24h).toFixed(2) +"%";

            var priceChangeElement = row.find(".price-change");

            priceChangeElement
               .removeClass("up down neutral")
               .addClass(priceClass)
               .html(`${priceChangeIcon} ${priceChangeValue}`)
          }
        });
      },
      error: function(err){
        console.error("Error Fetching update coin data:", err);
      }
    });
  }, 30000);
})