let resultArray=new Set()
function permutation(str, start, end){
    console.log("====== Permutation called str : ",str," start : ",start," end : ",end,"  ======");
    if(start == end){
        resultArray.add(str)
    }
    else{
        for(let i = start; i <= end; i++){
            str = swap(str,start,i)
            permutation(str,start+1, end)
            str = swap(str,start,i)
        }
    }
    console.log("====== Permutation Ended  ======");

}
function swap(str,start,end){

    console.log("***** Swap called start : ",start," end : ",end,"  *****");
    let str_array = str.split("")
    console.log("str_array Begin ",str_array);
    let temp = str_array[start]
    str_array[start] = str_array[end]
    str_array[end]=temp
    console.log("str_array End ",str_array);
    return str_array.join("")
}

original_string = "AABC"
permutation(original_string,0,original_string.length-1)
console.log(resultArray)
