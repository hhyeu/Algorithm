package tree;

public class Pair<K, V> {
	public K key;
	public V value;
	
	public Pair() {}
	
	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Pair [key=" + key + ", value=" + value + "]";
	}
	
}
