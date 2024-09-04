package collections;

import exceptions.EmptyListException;
import exceptions.FullListException;

public class StaticList<E> implements List<E> {
  private int size;
  private E[] list;

  @SuppressWarnings("unchecked")
  public StaticList(int capacity) {
    this.list = (E[]) new Object[capacity];
  }

  @Override
  public void add(E element) throws FullListException {
    if (this.isFull()) {
      throw new FullListException("Static List is full");
    }

    this.list[size++] = element;
  }

  @Override
  public void insert(E element) throws FullListException {
    if (this.isFull()) {
      throw new FullListException("Static List is full");
    }
    for (int i = size; i > 0; i --) {
      this.list[i] = this.list[i - 1];
    }

    this.list[0] = element;
    this.size++;
  }

  @Override
  public void insertByIndex(int index, E element) throws FullListException {
    if (this.isFull()) {
      throw new FullListException("Static List is full");
    }

    if (index <= 0) {
      this.insert(element);
    } else if (index >= size) {
      this.add(element);
    } else {
      for (int i = size; i > index; i --) {
        this.list[i] = this.list[i - 1];
      }

      this.list[index] = element;
      this.size++;
    }
  }

  @Override
  public void set(int index, E element) throws EmptyListException, IndexOutOfBoundsException {
    if (isEmpty()) {
      throw new EmptyListException("Static List is empty");
    }

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    this.list[index] = element;
  }

  @Override
  public E get(int index) throws EmptyListException, IndexOutOfBoundsException {
    if (isEmpty()) {
      throw new EmptyListException("Static List is empty");
    }

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    return this.list[index];
  }

  @Override
  public E removeLast() throws EmptyListException {
    if (this.isEmpty()) {
      throw new EmptyListException("Static List is empty");
    }

    return this.list[--size];
  }

  @Override
  public E removeFirst() throws EmptyListException {
    if (this.isEmpty()) {
      throw new EmptyListException("Static List is empty");
    }

    return removeByIndex(0);
  }

  @Override
  public E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException {
    if (this.isEmpty()) {
      throw new EmptyListException("Static List is empty");
    }

    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index out of bounds");
    }

    E element = this.list[index];

    for (int i = index; i < size - 1; i ++) {
      this.list[i] = this.list[i + 1];
    }

    this.size--;
    return element;
  }


  @Override
  public boolean isFull() {
    return this.size == this.list.length;
  }

  @Override
  public boolean isEmpty() {
    return this.size == 0;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public void clear() {
    this.size = 0;
  }
}
