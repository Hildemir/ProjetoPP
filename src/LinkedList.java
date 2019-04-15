public class LinkedList<K, V> {
    private Node<K, V> head;
    private Node<K, V> last;

    public void put (K key, V value) {
        Node node = new Node(value, key);
        if (head == null) {
            head = node;
            last = node;
        } else {
            last.setNext(node);
            last = node;
        }
    }

    public boolean containsKey(K key){
        Node<K, V> aux = head;
        while (aux != null) {
            if (aux.getKey().equals(key)) {
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public V get(K key){
        Node<K, V> aux = head;
        while (aux != null) {
            if (aux.getKey().equals(key)) {
                return aux.getValue();
            }
            aux = aux.getNext();
        }
        return null;
    }

    public void remove(K key){
        if (head.getKey().equals(key)) {
            head = head.getNext();
            if (head == null) {
                last = null;
            }
            return;
        }
        Node<K, V> prev = head;
        Node<K, V> aux = head.getNext();
        while (aux != null) {
            if (aux.getKey().equals(key)) {
                prev.setNext(aux.getNext());
                if (last == aux){
                    last = prev;
                }
                return;
            }
            prev = prev.getNext();
            aux = aux.getNext();
        }
    }

    public Node<K, V> getHead() {
        return head;
    }

    public Node<K, V> getLast() {
        return last;
    }
}
