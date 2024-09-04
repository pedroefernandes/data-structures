package collections;

import exceptions.EmptyListException;
import exceptions.FullListException;

public interface List<E> {
  public void add(E element) throws FullListException;
  public void insert(E element) throws FullListException;
  public void insertByIndex(int index, E element) throws FullListException;

  public void set(int index, E element) throws EmptyListException, IndexOutOfBoundsException;
  public E get(int index) throws EmptyListException, IndexOutOfBoundsException;

  public E removeLast() throws EmptyListException;
  public E removeFirst() throws EmptyListException;
  public E removeByIndex(int index) throws EmptyListException, IndexOutOfBoundsException;

  public boolean isEmpty();
  public boolean isFull();

  public int size();
  public void clear();
}
