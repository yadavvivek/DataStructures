package com.vivek.ds;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("unchecked")
public class HashTableQuadraticProbing<K,V> implements Iterable<K>{
	
	private static final double DEFAULT_LOAD_FACTOR = 0.50;
	private static final int DEFAULT_CAPACITY = 8;
	
	private int capacity, threshold, usedBuckets, modificationCount, keyCount = 0;
	private double maxLoadFactor;
	
	private K[] keyTable;
	private V[] valueTable;
	
	private final K TOMBSTONE =  (K) new Object();
	
	public HashTableQuadraticProbing() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	public HashTableQuadraticProbing(int capacity) {
		this(capacity, DEFAULT_LOAD_FACTOR);
	}
	
	public HashTableQuadraticProbing(int capacity, double maxLoadFactor) {
		if( capacity <= 0 ) throw new IllegalArgumentException("Capacity must be greater than 0!");
		
		this.capacity = capacity;
		this.maxLoadFactor = maxLoadFactor;
		threshold = (int) (capacity*maxLoadFactor);
		
		keyTable = (K[]) new Object[this.capacity];
		valueTable = (V[]) new Object[this.capacity];
	}
	
	public int size() {
		return keyCount;
	}
	
	public boolean isEmpty() {
		return keyCount == 0;
	}
	
	public V add(K key, V value) {
		return insert(key, value);
	}
	
	public V put(K key, V value) {
		return insert(key, value);
	}
	
	private int normalizedIndex(int hash) {
		return (hash & 0x7FFFFFFF) % capacity;
	}
	
	public V insert(K key, V value) {
		if(key == null) throw new IllegalArgumentException("Illegal Key :"+key);
		if(usedBuckets > threshold) resizeTable();
		int offset = normalizedIndex(key.hashCode());
		
		for(int i = offset, j = -1, x = 1; ; i = normalizedIndex(offset + probe(x++))) {
			if(keyTable[i] == TOMBSTONE) {
				if(j == -1) j = i;
			} else if (keyTable[i] != null) {
				if(keyTable[i].equals(key)) {
					V oldValue = valueTable[i];
					if(j == -1) {
						valueTable[i] = value;
					} else {
						keyTable[i] = TOMBSTONE;
						valueTable[i] = null;
						keyTable[j] = key;
						valueTable[j] = value;
					}
					modificationCount++;
					return oldValue;
				}
			} else {
				if(j == -1) {
					keyTable[i] = key;
					valueTable[i] = value;
					keyCount++;
					usedBuckets++;
				} else {
					valueTable[j] = value;
					keyTable[j] = key;
					keyCount++;
 				}

				modificationCount++;
				return null;
			}
		}
	}
	
	private void resizeTable() {
		capacity *= 2;
		
		threshold = (int) (capacity*maxLoadFactor);
		
		K[] oldKeyTable = (K[]) new Object[capacity];
		V[] oldValueTable = (V[]) new Object[capacity];
		
		
		K[] tempKeyTable = keyTable;
		keyTable = oldKeyTable;
	    oldKeyTable = tempKeyTable;
	    
	    V[] tempValueTable = valueTable;
	    valueTable = oldValueTable;
	    oldValueTable = tempValueTable;
	    
	    usedBuckets = keyCount = 0;
	    
	    for(int i = 0; i < oldKeyTable.length; i++) {
	    	if(oldKeyTable[i] != null || oldKeyTable[i] != TOMBSTONE) {
	    		insert(oldKeyTable[i], oldValueTable[i]);
	    	}
	    	oldKeyTable[i] = null;
	    	oldValueTable[i] = null;
	    }
	}
	
	private int probe(int x) {
		return (x*x + x) << 1;
	}
	
	public V get(K key) {
		if(key == null) throw new IllegalArgumentException("Key is null");
		
		int offset = normalizedIndex(key.hashCode());
		
		for(int i = offset, j = -1, x = 1; ; i = normalizedIndex(offset + probe(x++))) {
			
			if(keyTable[i] == TOMBSTONE) {
				if(j == -1) j = i;
			} else if (keyTable[i] != null) {
				if(keyTable[i].equals(key)) {
					
					if(j != -1) {
						keyTable[j] = keyTable[i];
						valueTable[j] = valueTable[i];
						valueTable[i] = null;
						keyTable[i] = TOMBSTONE; 
						return valueTable[j];
					} else {
						return valueTable[i];	
					}
					
				}
			} else {
				return null;
					
			}
		}
	}
	
	public V remove(K key) {
		if(key == null ) throw new IllegalArgumentException();
		
		int offset = normalizedIndex(key.hashCode());
		
		for(int i = offset, x = 1; ; i = normalizedIndex(offset + probe(x++))) {
			if(keyTable[i] == TOMBSTONE) continue;
			
			if(keyTable[i] == null ) return null;
	
			if(keyTable[i].equals(key)) {
				keyCount--;
					
				keyTable[i] = TOMBSTONE;
				V value = valueTable[i];
				valueTable[i] = null;
				return value;
			}
			
		}
	}
	
	public List<K> keys() {
		List<K> keys = new ArrayList<>();
		for(int i = 0; i < keyTable.length; i++) {
			if(keyTable[i] != null && keyTable[i] != TOMBSTONE) {
				keys.add(keyTable[i]);
			}
		}
		return keys;
	}
	
	public List<V> values() {
		List<V> values = new ArrayList<>();
		for(int i = 0; i < keyTable.length; i++) {
			if(keyTable[i] != null && keyTable[i] != TOMBSTONE) {
				values.add(valueTable[i]);
			}
		}
		return values;
	}
	
	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
