

/**
 * This Algorithm is KMP String Matching Alogorithm and contain search method which take two arguments 
 * text-- in which we are searching
 * pattern -- which is may or may not present in the text
 * 
 * return value : if pattern exists in the text array of indexes else -1 will be return
 */
class KMPStringMatch{
    constructor(){
    }

    /**
     * 
     * @param  text 
     * @param  pattern 
     * ALGORITHMS :
     *  AFTER Constructing Longest PrefixArray with same Suffix
     *  we Traverse from i =0 to end of the text and j =0 to end of pattern
     *  STEP 1 : if text[i] == pattern[j] just increment i++ and j++
     *  STEP 2 : if j == Length of pattren push the i-j value to result Array
     *  STEP 3 : If j != Length of Pattern
     *          check j == 0 (pointer of pattren is at the first position)
     *                 YES : i ++
     *                 NO  : j = LPS[j-1]
     */
    search(text,pattern){
        let positionArray=[];
        // i is for text pointer
        let i = 0;
        // j is for pattern pointer
        let j = 0;
        let textLength = text.length;
        let patternLength = pattern.length;
        let lps = this.constructLPS(pattern);
        console.log(lps);
        // "ABABDABACDABABCABAB","ABABCABAB"
        while(i<textLength){
            if(text.charAt(i) == pattern.charAt(j)){
                i++;
                j++;
            }
            if(j==patternLength){
                positionArray.push(i-j);
                j = lps[j-1]
            }
            else if(i< textLength && text.charAt(i) != pattern.charAt(j)){
                if(j != 0){
                    j = lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        return positionArray.length > 0 ? positionArray : -1;
    }

    /***
     * CONSTRUCTION OF LONGEST SAME PREFIX AND SUFFIX ARRAY(LPS)
     * STEP 1 : Initialise i =0 and j =1
     * STEp 2 : check if pattern[i] == pattern[j]
     *          YES : LPS[j] = i + 1 , i++ and j++
     *          NO : check i == 0 
     *                  YES : LPS[j] = 0 and j++
     *                  NO : i = LPS [ i-1]
     */
    constructLPS(pattern){
        let lps =[]
        let i = 0;
        let j = 1;
        lps.length = pattern.length;
        lps.fill(0);
        while(j < pattern.length){
            if(pattern.charAt(i) == pattern.charAt(j)){
                lps[j]=i+1;
                i++;
                j++;
            }
            else{
                if(i!=0){
                    i = lps[i-1]
                }
                else{
                    lps[j]=0;
                    j++
                }
            }
        }
        return lps
    }
}

const kmp = new KMPStringMatch();
console.log(kmp.search("ABABDABACDABABCABAB","ABAB"));
