document .addEventListener('DOMContentLoaded', function(){
  var coinFilter = document.getElementById('coinSearch');  //searched by html line18
  var coinRows = document.querySelectorAll('.coinRow');

  console.log('Debug coin-search.js');

  coinFilter.addEventListener('input',function(){   //every input, trigger function once
     var filterValue = coinFilter.value.toUpperCase();
     coinRows.forEach(function(row){
      var coinName = row.querySelector('td:nth-child(1)').textContent.toUpperCase();  //1st column
      if(coinName.indexOf(filterValue) > -1){  //>-1 -> included in input textbox
         row.style.display = '';
      }else{
        row.style.display = 'none';
      }
      });
  })

})