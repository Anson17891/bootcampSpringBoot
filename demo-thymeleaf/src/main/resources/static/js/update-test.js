function updateText(){
  const inputValue = document.getElementById("input-box").value; 
  //!value in input box store in const inputValue
  document.getElementById("status").textContent = inputValue; 
   //!find id=:status" (aka <p id="status">Origiinal Value</p> ), change to const inputValue
}