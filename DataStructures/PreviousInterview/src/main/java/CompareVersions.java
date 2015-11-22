/**
 * Created by chanumolu on 10/21/15.
 */

/**
 * Microsoft Interview
 *
 * Given two version strings, write a function to compare the version strings.
 *
 * if V1>V2 return +ve number
 * if V1<V2 return -ve number
 * if V1==v2 return 0
 *
 * eg: v1 = 10.8.8 , v2 = 8.1.1.1
 */
public class CompareVersions {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        int i=0;
        while(i<arr1.length || i<arr2.length){
            if(i<arr1.length && i<arr2.length){
                if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])){
                    return -1;
                }else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])){
                    return 1;
                }
            } else if(i<arr1.length){
                if(Integer.parseInt(arr1[i]) != 0){
                    return 1;
                }
            } else if(i<arr2.length){
                if(Integer.parseInt(arr2[i]) != 0){
                    return -1;
                }
            }

            i++;
        }

        return 0;
    }
}
