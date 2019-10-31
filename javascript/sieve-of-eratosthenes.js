function SieveOfEratosthenes(n){
  let primes = [];
  primes.length = n+1
  primes.fill(true);
  primes[0]=false;
  primes[1]=false;
  for(let i =2;i * i < n ; i++){
    if(primes[i] == true){
      for(let j = i * i ; j < n+1; j = j + i){
        primes[j]=false;
      }
    }
  }
  let p =[];
  primes.map((ele,index)=>{
    if(ele) p.push(index)
  })
  return p
}
console.log(SieveOfEratosthenes(100));
