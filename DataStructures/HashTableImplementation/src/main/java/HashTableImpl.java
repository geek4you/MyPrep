/**
 * Created by chanumolu on 7/29/15.
 */



import java.util.ArrayList;
import java.util.List;

/**
 * Brief intro
 *
 * Hash table is used to store objects according to their key in an array. Objects are stored in array based on the hash value
 * of the key. This value is computed from the key by hash function. If two keys map to the same location, a collision occurs.
 * There are two standard methods to deal with collisions.

 Separate Chaining

 A chained hash table indexes into an array of pointers to the heads of linked lists. Each linked list cell has the key for
 which it was allocated and the value which was inserted for that key. When you want to look up a particular element from its
 key, the key's hash is used to work out which linked list to follow, and then that particular list is traversed to find the
 element that you're after. If more than one key in the hash table has the same hash, then you'll have linked lists with more
 than one element.

 The downside of chained hashing is having to follow pointers in order to search linked lists. The upside is that chained hash
 tables only get linearly slower as the load factor (the ratio of elements in the hash table to the length of the bucket array)
 increases, even if it rises above 1.

 Open addressing

 An open-addressing hash table indexes into an array of pointers to pairs of (key, value). You use the key's hash value to work
 out which slot in the array to look at first. If more than one key in the hash table has the same hash, then you use some scheme
 to decide on another slot to look in instead. For example, linear probing is where you look at the next slot after the one
 chosen, and then the next slot after that, and so on until you either find a slot that matches the key you're looking for,
 or you hit an empty slot (in which case the key must not be there). Open-addressing is usually faster than chained hashing
 when the load factor is low because you don't have to follow pointers between list nodes. It gets very, very slow if the load
 factor approaches 1, because you end up usually having to search through many of the slots in the bucket array before you find
 either the key that you were looking for or an empty slot. Also, you can never have more elements in the hash table than there
 are entries in the bucket array.

 */
public class HashTableImpl<K,V> implements IMap<K,V>{

    public static enum Type { CHAINING, PROBING }
    private HashTableImpl<K,V> delegateMap = null;

    private static class ChainingHashMap<K, V> extends HashTableImpl<K, V> {

        private float loadFactor = 10.0f;
        private int minimumSize = 1024;
        private int initialListSize = 10;
        private List<Pair<K, V>>[] array = null;
        private int size = 0;

        /**
         * Create a hash map with K as the hashing key.
         *
         * @param size
         *            initial size.
         */
        public ChainingHashMap(int size) {
            initializeMap(size);
        }

        /**
         * Create a hash map with the default hashing key.
         */
        public ChainingHashMap() {
            initializeMap(minimumSize);
        }

        /**
         * Put
         * @param key to be inserted.
         * @param value to be inserted.
         * @return
         */
        public V put(K key, V value) {
            return put(new Pair<K, V>(key, value));
        }

        public V put(Pair<K,V> newPair) {
            int index = indexOf(newPair.key.hashCode());
            List<Pair<K, V>> list = array[index];
            V prev = null;
            boolean exist = false;
            // Do not add duplicates
            for (Pair<K, V> p : list) {
                if (p.key.equals(newPair.key)) {
                    prev = p.value;
                    p.value = newPair.value;
                    exist = true;
                    break;
                }
            }

            if (!exist)
                list.add(newPair);

            size++;

            // If size is greater than threshold
            int maxSize = (int)(loadFactor*array.length);
            if (size >= maxSize)
                increase();

            return prev;
        }

        /**
         * get
         *
         * @param key to get value for.
         * @return
         */
        public V get(K key) {
            int index = indexOf(key.hashCode());
            List<Pair<K, V>> list = array[index];
            for (Pair<K, V> p : list) {
                if (p.key.equals(key))
                    return p.value;
            }
            return null;
        }

        /**
         * Contains
         * @param key to locate in the map.
         * @return
         */
        public boolean contains(K key) {
            return (get(key)!=null);
        }

        /**
         * remove
         *
         * @param key to remove from the map.
         * @return
         */
        public V remove(K key) {
            int index = indexOf(key.hashCode());
            List<Pair<K, V>> list = array[index];
            for (Pair<K, V> pair : list) {
                if (pair.key.equals(key)) {
                    list.remove(pair);
                    size--;

                    V value = pair.value;
                    pair.key = null;
                    pair.value = null;

                    int loadFactored = (int)(size/loadFactor);
                    int smallerSize = getSmallerSize(array.length);
                    if (loadFactored < smallerSize && smallerSize > minimumSize)
                        reduce();

                    return value;
                }
            }
            return null;
        }

        /**
         * clear
         *
         */
        public void clear() {
            for (int i=0; i<array.length; i++)
                array[i].clear();
            size = 0;
        }

        /**
         * Size
         *
         * @return
         */
        public int size() {
            return size;
        }

        /**
         * Increase the size
         */
        private void increase() {
            // Save old data
            List<Pair<K, V>>[] temp = this.array;

            // Calculate new size and assign
            int length = getLargerSize(array.length);
            //System.out.println("increase from "+array.length+" to "+length);
            initializeMap(length);

            // Re-hash old data
            for (List<Pair<K, V>> list : temp) {
                for (Pair<K, V> p :list) {
                    this.put(p);
                }
            }
        }

        /**
         * Reduce
         */
        private void reduce() {
            // Save old data
            List<Pair<K, V>>[] temp = this.array;

            // Calculate new size and check minimum
            int length = getSmallerSize(array.length);
            //System.out.println("reduce from "+array.length+" to "+length);
            initializeMap(length);

            // Re-hash old data
            for (List<Pair<K, V>> list : temp) {
                for (Pair<K, V> p :list) {
                    this.put(p);
                }
            }
        }

        /**
         * Increases the input ten-fold. e.g. 16->160
         */
        private static final int getLargerSize(int input) {
            return input*10;
        }

        /**
         * Returns one fourth of the input. e.g. 16->4
         */
        private static final int getSmallerSize(int input) {
            return input/4;
        }

        /**
         * Initialize the hash array.
         */
        private void initializeMap(int length) {
            this.array = new ArrayList[length];
            for (int i = 0; i < array.length; i++)
                this.array[i] = new ArrayList<Pair<K, V>>(initialListSize);
            this.size = 0;
        }


        /**
         * Converts the key into an integer.
         *
         * @param h
         *            hash to get index of.
         *
         * @return Integer which represents the key.
         */
        private int indexOf(int h) {
            return h & (array.length-1);
        }

        /**
         *
         * @return
         */
        public java.util.Map<K,V> toMap() {
            return (new JavaCompatibleHashMap<K,V>(this));
        }

        /**
         *
         * @return
         */
        public boolean validate() {
            java.util.Set<K> keys = new java.util.HashSet<K>();
            for (List<Pair<K, V>> list : array) {
                for (Pair<K, V> pair : list) {
                    K k = pair.key;
                    V v = pair.value;
                    if (k==null || v==null) return false;
                    if (keys.contains(k)) return false;
                    keys.add(k);
                }
            }
            return (keys.size()==size());
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int key = 0; key < array.length; key++) {
                List<Pair<K, V>> list = array[key];
                for (int item = 0; item < list.size(); item++) {
                    Pair<K, V> p = list.get(item);
                    V value = p.value;
                    if (value != null) builder.append(key).append("=").append(value).append(", ");
                }
            }
            return builder.toString();
        }

        private static class JavaCompatibleHashMap<K,V> extends java.util.AbstractMap<K,V> {

            private ChainingHashMap<K,V> map = null;

            protected JavaCompatibleHashMap(ChainingHashMap<K,V> map) {
                this.map = map;
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public V put(K key, V value) {
                return map.put(key, value);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public V remove(Object key) {
                return map.remove((K)key);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public boolean containsKey(Object key) {
                return map.contains((K)key);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public void clear() {
                map.clear();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public int size() {
                return map.size();
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
                java.util.Set<java.util.Map.Entry<K, V>> set = new java.util.HashSet<java.util.Map.Entry<K, V>>() {

                    private static final long serialVersionUID = 1L;

                    /**
                     * {@inheritDoc}
                     */
                    @Override
                    public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
                        return (new JavaCompatibleIteratorWrapper<K,V>(map,super.iterator()));
                    }
                };
                for (List<Pair<K, V>> list : map.array) {
                    for (Pair<K, V> p : list) {
                        java.util.Map.Entry<K, V> entry = new JavaCompatibleMapEntry<K, V>(p.key, p.value);
                        set.add(entry);
                    }
                }
                return set;
            }
        }


    }

    /**
     * Probing HashMap
     * @param <K>
     * @param <V>
     */
    private static class ProbingHashMap<K, V> extends HashTableImpl<K, V> {
        private int hashingKey = -1;
        private float loadFactor = 0.6f;
        private int minimumSize = 1024;
        private Pair<K, V>[] array = null;
        private int size = 0;

        /**
         * Create a hash map with K as the hash.
         *
         * @param size
         *            to use for the hash.
         */
        public ProbingHashMap(int size) {
            initializeMap(size);
        }

        /**
         * Create a hash map with the default hashing key.
         */
        public ProbingHashMap() {
            initializeMap(minimumSize);
        }

        /**
         * {@inheritDoc}
         */
        public V put(K key, V value) {
            return put(new Pair<K,V>(key,value));
        }

        private V put(Pair<K,V> newPair) {
            V prev = null;
            int index = indexOf(newPair.key);

            // Check initial position
            Pair<K, V> pair = array[index];
            if (pair == null) {
                array[index] = newPair;
                size++;

                // If size is greater than threshold
                int maxSize = (int)(loadFactor*array.length);
                if (size >= maxSize)
                    increase();

                return prev;
            }

            if (pair.key.equals(newPair.key)) {
                prev = pair.value;
                pair.value = newPair.value;
                return prev;
            }

            // Probing until we get back to the starting index
            int start = getNextIndex(index);
            while (start != index) {
                pair = array[start];
                if (pair == null) {
                    array[start] = newPair;
                    size++;

                    // If size is greater than threshold
                    int maxSize = (int)(loadFactor*array.length);
                    if (size >= maxSize)
                        increase();

                    return prev;
                }

                if (pair.key.equals(newPair.key)) {
                    prev = pair.value;
                    pair.value = newPair.value;
                    return prev;
                }

                start = getNextIndex(start);
            }
            // We should never get here.
            return null;
        }

        /**
         * {@inheritDoc}
         */
        public V get(K key) {
            int index = indexOf(key);
            Pair<K, V> pair = array[index];

            // Check initial position
            if (pair == null)
                return null;
            if (pair.key.equals(key))
                return pair.value;

            // Probing until we get back to the starting index
            int start = getNextIndex(index);
            while (start != index) {
                pair = array[start];

                if (pair == null)
                    return null;
                if (pair.key.equals(key))
                    return pair.value;

                start = getNextIndex(start);
            }
            // If we get here, probing failed.
            return null;
        }

        /**
         * {@inheritDoc}
         */
        public boolean contains(K key) {
            return (get(key)!=null);
        }

        /**
         * {@inheritDoc}
         */
        public V remove(K key) {
            int index = indexOf(key);
            Pair<K, V> prev = null;

            // Check initial position
            Pair<K, V> pair = array[index];
            if (pair != null && pair.key.equals(key)) {
                prev = array[index];
                array[index] = null;
                size--;

                int loadFactored = (int)(size/loadFactor);
                int smallerSize = getSmallerSize(array.length);
                if (loadFactored < smallerSize && smallerSize > minimumSize)
                    reduce();

                return prev.value;
            }

            // Probing until we get back to the starting index
            int start = getNextIndex(index);
            while (start != index) {
                pair = array[start];
                if (pair != null && pair.key.equals(key)) {
                    prev = array[start];
                    array[start] = null;
                    size--;

                    int loadFactored = (int)(size/loadFactor);
                    int smallerSize = getSmallerSize(array.length);
                    if (loadFactored < smallerSize && smallerSize > minimumSize)
                        reduce();

                    return prev.value;
                }
                start = getNextIndex(start);
            }
            // If we get here, probing failed.
            return null;
        }

        /**
         * {@inheritDoc}
         */
        public void clear() {
            for (int i=0; i<array.length; i++)
                array = null;
            size = 0;
        }

        /**
         * {@inheritDoc}
         */
        public int size() {
            return size;
        }

        private void initializeMap(int current) {
            int length = getLargerSize(current);
            array = new Pair[length];
            size = 0;
            hashingKey = length;
        }

        private void increase() {
            // Save old data
            Pair<K,V>[] temp = this.array;

            // Calculate new size and assign
            int length = getLargerSize(array.length);
            //System.out.println("increase from "+array.length+" to "+length);
            initializeMap(length);

            // Re-hash old data
            for (Pair<K,V> p : temp) {
                if (p != null)
                    this.put(p);
            }
        }

        private void reduce() {
            // Save old data
            Pair<K,V>[] temp = this.array;

            // Calculate new size and check minimum
            int length = getSmallerSize(array.length);
            //System.out.println("reduce from "+array.length+" to "+length);
            initializeMap(length);

            // Re-hash old data
            for (Pair<K,V> p : temp) {
                if (p != null)
                    this.put(p);
            }
        }

        /**
         * Doubles the input. e.g. 16->32
         */
        private static final int getLargerSize(int input) {
            return input<<1;
        }

        /**
         * Returns one fourth of the input. e.g. 16->8->4
         */
        private static final int getSmallerSize(int input) {
            return input>>1>>1;
        }

        /**
         * Returns the next index in the probing sequence, at this point it's linear
         */
        private int getNextIndex(int input) {
            int i = input+1;
            if (i >= array.length)
                i = 0;
            return i;
        }

        /**
         * The hashing function. Converts the key into an integer.
         *
         * @param key
         *            to create a hash for.
         * @return Integer which represents the key.
         */
        private int indexOf(K key) {
            int k = key.hashCode() % hashingKey;
            if (k>=array.length)
                k = k - ((k/array.length) * array.length);
            return k;
        }

        /**
         * {@inheritDoc}
         */
        public java.util.Map<K,V> toMap() {
            return (new JavaCompatibleHashMap<K,V>(this));
        }

        /**
         * {@inheritDoc}
         */
        public boolean validate() {
            java.util.Set<K> keys = new java.util.HashSet<K>();
            for (Pair<K, V> pair : array) {
                if (pair == null)
                    continue;

                K k = pair.key;
                V v = pair.value;
                if (k==null || v==null)
                    return false;
                if (keys.contains(k))
                    return false;
                keys.add(k);
            }
            return (keys.size()==size());
        }

        /**
         * {@inheritDoc}
         */
        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int key = 0; key < array.length; key++) {
                Pair<K, V> p = array[key];
                if (p == null)
                    continue;
                V value = p.value;
                if (value != null)
                    builder.append(key).append("=").append(value).append(", ");
            }
            return builder.toString();
        }

        private static class JavaCompatibleHashMap<K,V> extends java.util.AbstractMap<K,V> {

            private ProbingHashMap<K,V> map = null;

            protected JavaCompatibleHashMap(ProbingHashMap<K,V> map) {
                this.map = map;
            }

            /**
             * {@inheritDoc}
             */
            public V put(K key, V value) {
                return map.put(key, value);
            }

            /**
             * {@inheritDoc}
             */
            public V remove(Object key) {
                return map.remove((K)key);
            }

            /**
             * {@inheritDoc}
             */
            public boolean containsKey(Object key) {
                return map.contains((K)key);
            }

            /**
             * {@inheritDoc}
             */
            public void clear() {
                map.clear();
            }

            /**
             * {@inheritDoc}
             */
            public int size() {
                return map.size();
            }

            /**
             * {@inheritDoc}
             */
            public java.util.Set<java.util.Map.Entry<K, V>> entrySet() {
                java.util.Set<java.util.Map.Entry<K, V>> set = new java.util.HashSet<java.util.Map.Entry<K, V>>() {

                    private static final long serialVersionUID = 1L;

                    /**
                     * {@inheritDoc}
                     */
                    public java.util.Iterator<java.util.Map.Entry<K, V>> iterator() {
                        return (new JavaCompatibleIteratorWrapper<K,V>(map,super.iterator()));
                    }
                };
                for (Pair<K, V> p : map.array) {
                    if (p==null)
                        continue;
                    java.util.Map.Entry<K, V> entry = new JavaCompatibleMapEntry<K, V>(p.key, p.value);
                    set.add(entry);
                }
                return set;
            }
        }
    }


    /**
     * Create a hash map with K as the hashing key.
     *
     * @param type
     *            type of hashing to use.
     * @param size
     *            initialize size.
     */
    public HashTableImpl(Type type, int size) {
        if (type == Type.CHAINING) {
            delegateMap = new ChainingHashMap<K,V>(size);
        } else if (type == Type.PROBING) {
            delegateMap = new ProbingHashMap<K,V>(size);
        }
    }

    /**
     * Create a hash map with the default hashing key.
     *
     * @param type
     *            type of hashing to use.
     */
    public HashTableImpl(Type type) {
        if (type == Type.CHAINING) {
            delegateMap = new ChainingHashMap<K,V>();
        } else if (type == Type.PROBING) {
            delegateMap = new ProbingHashMap<K,V>();
        }
    }

    private HashTableImpl() { }

    /**
     * {@inheritDoc}
     */
    public V put(K key, V value) {
        return delegateMap.put(key, value);
    }

    /**
     * {@inheritDoc}
     */
    public V get(K key) {
        return delegateMap.get(key);
    }

    /**
     * {@inheritDoc}
     */
    public boolean contains(K key) {
        return (get(key)!=null);
    }

    /**
     * {@inheritDoc}
     */
    public V remove(K key) {
        return delegateMap.remove(key);
    }

    /**
     * {@inheritDoc}
     */
    public void clear() {
        delegateMap.clear();
    }

    /**
     * {@inheritDoc}
     */
    public int size() {
        return delegateMap.size();
    }

    /**
     * {@inheritDoc}
     */
    public java.util.Map<K,V> toMap() {
        return delegateMap.toMap();
    }

    /**
     * {@inheritDoc}
     */
    public boolean validate() {
        return delegateMap.validate();
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return delegateMap.toString();
    }

    private static final class Pair<K, V> {

        private K key = null;
        private V value = null;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return 31 * (this.key.hashCode());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null)
                return false;
            if (!(obj instanceof Pair))
                return false;

            Pair<K, V> pair = (Pair<K, V>) obj;
            return key.equals(pair.key);
        }
    }

    private static class JavaCompatibleIteratorWrapper<K,V> implements java.util.Iterator<java.util.Map.Entry<K, V>> {

        private HashTableImpl<K,V> map = null;
        private java.util.Iterator<java.util.Map.Entry<K, V>> iter = null;
        private java.util.Map.Entry<K, V> lastEntry = null;

        public JavaCompatibleIteratorWrapper(HashTableImpl<K,V> map, java.util.Iterator<java.util.Map.Entry<K, V>> iter) {
            this.map = map;
            this.iter = iter;
        }

        /**
         * {@inheritDoc}
         */
        public boolean hasNext() {
            if (iter==null)
                return false;
            return iter.hasNext();
        }

        /**
         * {@inheritDoc}
         */
        public java.util.Map.Entry<K, V> next() {
            if (iter==null)
                return null;

            lastEntry = iter.next();
            return lastEntry;
        }

        /**
         * {@inheritDoc}
         */
        public void remove() {
            if (iter==null || lastEntry==null)
                return;

            map.remove(lastEntry.getKey());
            iter.remove();
        }
    }

    private static class JavaCompatibleMapEntry<K,V> extends java.util.AbstractMap.SimpleEntry<K,V> {

        private static final long serialVersionUID = 3282082818647198608L;

        public JavaCompatibleMapEntry(K key, V value) {
            super(key, value);
        }
    }
}
