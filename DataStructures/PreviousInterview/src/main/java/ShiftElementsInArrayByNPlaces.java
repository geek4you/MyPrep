/**
 * Created by chanumolu on 10/21/15.
 */

/**
 * Microsoft interview
 *
 * Given buffer array , shift all the elements in the buffer by N places.
 *
 * For example [3 4 5 2 3 1 4] shift m = 2 positions should be [1 4 3 4 5 2 3]
 * eg:
 *
 * Algorithm:
 shiftArray( theArray, M ):
 size = len( theArray )
 assert( size > M )
 reverseArray( theArray, 0, size - 1 )
 reverseArray( theArray, 0, M - 1 )
 reverseArray( theArray, M, size - 1 )
 */
public class ShiftElementsInArrayByNPlaces {

}

