/**
 * We are storing the index of curr_sum-sum in a map 
 * @param  arr which may contain negative numbers
 * @param  sum ay be positive or negative number
 * An efficient way is to use a map. 
 * The idea is to maintain sum of elements encountered so far in a variable (say curr_sum). 
 * Let the given number is sum. Now for each element, we check if curr_sum – sum exists in the map or not. 
 * If we found it in the map that means, we have a subarray present with given sum, 
 * else we insert curr_sum into the map and proceed to next element. 
 * If all elements of the array are processed and we didn’t find any subarray with given sum, 
 * then subarray doesn’t exists.
 */
function subArrayWithGivenSum(arr,sum){
    const map = new Map();
    let curr_sum = 0;
    for(let i=0;i<arr.length;i++){
        curr_sum +=arr[i];

        if(curr_sum == sum){
            return [0,i]
        } else if(map.has(curr_sum-sum)){
            return [map.get(curr_sum-sum)+1,i]
        }
        map.set(curr_sum,i)
    }
    return []
}
console.log(subArrayWithGivenSum([10,2,-2,-20,10],-22))