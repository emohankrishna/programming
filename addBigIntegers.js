function addBigInteger (str1, str2) {

  if (str1.length < str2.length) {
    let temp = str2;
    str2 = str1;
    str1 = temp;
  }
  let sum = "";
  let carry = 0;
  for (let i = 0; i < str1.length; i++) {
    let a = parseInt(str1.charAt(str1.length - i - 1));
    let b = parseInt(str2.charAt(str2.length - i - 1));
    b = b ? b : 0;
    let temp = parseInt(carry + a + b).toString();
    if (temp.length == 2) {
      carry = parseInt(temp.charAt(0));
      digSum = parseInt(temp.charAt(1)).toString();
    }
    else {
      carry = 0;
      digSum = parseInt(temp.charAt(0)).toString();
    }
    sum = digSum + sum
  }
  return sum;
  // console.log(sum)
  // console.log(parseInt(str1) + parseInt(str2) + "")
}

function subBigIntegers(str1,str2){
  
}
addBigInteger("56734523489758923758972345897834975892346541783453748906789", "224322834625345423762376578346257862347856783623789124534567872234445");
