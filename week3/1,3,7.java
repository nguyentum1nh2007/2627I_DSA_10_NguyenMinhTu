// Linked List
public Item peek() {
    if (isEmpty())
        throw new NoSuchElementException("Stack underflow");
    return first.item;
}

// Resizing Array
public Item peek() {
    if (isEmpty())
        throw new NoSuchElementException("Stack underflow");
    return a[n - 1];
}