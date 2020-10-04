package com.vivek.ds;

import java.util.*;

class Entry<K, V> {
	
	int hash;
	K key;
	V value;
	
	Entry(K key, V value) {
		this.key = key;
		this.value = value;
		this.hash = key.hashCode();
	}
	
	boolean equals(Entry<K,V> other) {
		if(hash != other.hash) return false;
		return key.equals(other.key);
	}
	
	@Override
	public String toString() {
		return key+ " => "+ value;
	}
}

@SuppressWarnings("unchecked")
public class HashTableSeparateChaining<K,V> implements Iterable<K> {

	private static int DEFAULT_CAPACITY = 3;
	private static double DEFAULT_LOAD_FACTOR = 0.75;
	
	private int capacity, threshold, size = 0;
	private double maxLoadFactor;
	private LinkedList<Entry<K,V>> [] table;
	
	public HashTableSeparateChaining() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	public HashTableSeparateChaining(int capacity) {
		this(capacity, DEFAULT_LOAD_FACTOR);
	}
	

	public HashTableSeparateChaining(int capacity, double maxLoadFactor) {
		if(capacity < 0) throw new IllegalArgumentException("Illegal argument!");
		if(maxLoadFactor <= 0) throw new IllegalArgumentException("Illegal maxLoadFactor!");
		this.capacity = capacity;
		this.maxLoadFactor = maxLoadFactor;
		this.threshold =  (int) (capacity * maxLoadFactor);
		table = new LinkedList[capacity];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void add(K key, V value) {
		insert(key, value);
	}
	
	public void put(K key, V value) {
		insert(key, value);
	}
	
	private V insert(K key, V value) {
		if(key == null ) throw new IllegalArgumentException("Key is null!");
		int bucketIndex = getNormalizedIndex(key.hashCode());
		LinkedList<Entry<K,V>> bucket = table[bucketIndex];
		Entry<K,V> entry = new Entry<K, V>(key, value);
		if(bucket == null) {
			table[bucketIndex] = bucket = new LinkedList<Entry<K,V>>();
		}
		Entry<K,V> existingEntry = seekEntryInBucket(bucketIndex, entry.key);
		if(existingEntry == null) {
			bucket.add(existingEntry);
			if(++size >= threshold) resizeTable();
			return null;
		} else {
			V oldValue = existingEntry.value;
			existingEntry.value = entry.value;
			return oldValue;
		}
	}
	
	private Entry<K, V> seekEntryInBucket(int bucketIndex, K key) {
		if (key == null) return null;
		
	    LinkedList<Entry<K,V>> bucket = table[bucketIndex];
	    if(bucket == null) return null;
	    
    	for(Entry<K, V> entry : bucket) {
    		if (entry.key.equals(key)) return entry;
    	}
		return null;
	}
	
	public int getNormalizedIndex(int hash) {
		return (hash & 0x7FFFFFFF) % capacity;
	}
	
	private void resizeTable() {
		capacity *= 2;
		LinkedList<Entry<K,V>>[] newTable = new LinkedList[capacity];
		threshold = (int) (capacity*maxLoadFactor);
		
		for(int i=0; i < table.length; i++) {
			LinkedList<Entry<K,V>> bucket = table[i];
			if(bucket!=null) {
				for(Entry<K,V> entry : bucket) {
					int bucketIndex = getNormalizedIndex(entry.hash);
					LinkedList<Entry<K,V>> newBucket = newTable[bucketIndex];
					if(newBucket == null)
						newBucket = newTable[bucketIndex] = new LinkedList<>();
					newBucket.add(entry);
				}
			}
			table[i].clear();
			table[i] = null;
		}
		table = newTable;
	}
	
	public boolean containsKey(K key) {
		return hasKey(key);
	}
	
	public boolean hasKey(K key) {
		int bucketIndex = getNormalizedIndex(key.hashCode());
		Entry<K,V> entry = seekEntryInBucket(bucketIndex, key);
		return entry != null;
	}
	
	public V remove(K key) {
		int bucketIndex = getNormalizedIndex(key.hashCode());
		return bucketRemoveEntry(bucketIndex, key);
	}
	
	private V bucketRemoveEntry(int bucketIndex, K key) {
		LinkedList<Entry<K,V>> list = table[bucketIndex];
		Entry<K,V> entry = seekEntryInBucket(bucketIndex, key);
		if(entry != null) {
			list.remove(entry);
			size--;
			return entry.value;
		}
		return null;
	}
	
	public List<K> keys() {
		List<K> keys = new ArrayList<K>();
		for(int i = 0; i < table.length; i++) {
			LinkedList<Entry<K,V>> list = table[i];
			if(list != null) {
				for(Entry<K,V> entry : list) {
					if(entry != null) {
						keys.add(entry.key);
					}
				}
			}
		}
		
		return keys;
	}
	
	public List<V> values() {
		List<V> values = new ArrayList<>();
		for(LinkedList<Entry<K,V>> bucket : table) {
			if(bucket != null) {
				for(Entry<K,V> entry : bucket) {
					values.add(entry.value);
				}
			}
		}
		
		return values;
	}
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{ ");
		for(LinkedList<Entry<K,V>> bucket : table) {
			for(Entry<K,V> entry : bucket) {
				sb.append(entry + ", ");
			}
		}
		sb.append(" }");
		return sb.toString();
	}
	
	public java.util.Iterator<K> iterator() {
		int elementCount  = size;
		
		return new java.util.Iterator<K>() {
			int bucketIndex  = 0;
			java.util.Iterator<Entry<K,V>> bucketIter = (table[0] == null) ? null : table[0].iterator();
			
			@Override
			public boolean hasNext() {
				
				if(elementCount != size) throw new ConcurrentModificationException("Hash table has been modified in between.");
				
				if(bucketIter == null || !bucketIter.hasNext()) {
					while(++bucketIndex < capacity) {
						if(table[bucketIndex] != null) {
							java.util.Iterator<Entry<K,V>> tempIter = table[bucketIndex].iterator();
							if(tempIter.hasNext()) {
								bucketIter = tempIter;
								break;
							}
						}
					}
				}
				
				return bucketIndex < capacity;
			}
			@Override
			public K next() {
				return bucketIter.next().key;
			}
		};
		
	}
}
