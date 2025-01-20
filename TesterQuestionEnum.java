public enum TesterQuestionEnum {
    // LinkedListTest
    LINKED_LIST_ADD_FIRST("LinkedList class. Adds the given memory block to the beginning of this list.", 6),
    LINKED_LIST_ADD_LAST("LinkedList class. Adds the given memory block to the end of this list.", 6),
    LINKED_LIST_GET_NODE("LinkedList class. Gets the memory block located at the given index in this list.", 6),
    LINKED_LIST_GET_BLOCK("LinkedList class. Gets the memory block located at the given index in this list.", 6),
    LINKED_LIST_ADD("LinkedList class. Adds the given memory block to this list.", 6),
    LINKED_LIST_INDEX_OF("LinkedList class. Gets the index of the node pointing to the given memory block.", 6),
    LINKED_LIST_REMOVE_NODE("LinkedList class. Removes the given node from this list.", 8),
    LINKED_LIST_REMOVE_ELEMENT("LinkedList class. Removes the given memory block from this list.", 8),
    LINKED_LIST_REMOVE_INDEX("LinkedList class. Removes the node at the given index from this list.", 8),
    MEMORY_SPACE_MALLOC("MemorySpace class. Allocates a memory block of the given size.", 15),
    MEMORY_SPACE_FREE("MemorySpace class. Frees the memory block at the given address.", 15),
    MEMORY_SPACE_DEFRAG("MemorySpace class. Defragments the memory space.", 10);

    private final String question;
    private final int maxPoints;
    TesterQuestionEnum(String question, int maxPoints) {
        this.question = question;
        this.maxPoints = maxPoints;
    }

    public String getQuestion() {
        return this.question;
    }

    public int getMaxPoints() {
        return this.maxPoints;
    }
}
