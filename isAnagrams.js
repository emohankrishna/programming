function isAnagrams(s1,s2){
    if(s1.length != s2.length) return false;
    let charArray = Array.from({length: 255}, (v, i) => 0) 
    // charArray.length = 255;
    s1 = s1.toLowerCase();
    s2 = s2.toLowerCase();
    for(let char of s1){
        charArray[char.charCodeAt(0)]++;
    }
    // console.log(charArray.toString())
    for(let char of s2){
        charArray[char.charCodeAt(0)]--;
    }
    // console.log(charArray.toString())
    for(let i = 0; i < charArray.length; i++){
        if(charArray[i]!=0) return false;
    }
    return true;
}
console.log(isAnagrams("ABCD","CBLA"));