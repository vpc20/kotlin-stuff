class Nodex(val key: Int) {
    var next: Nodex? = null
}

class LinkedList() {
    var head: Nodex? = null

    fun prepend(key: Int) {
        val newNode: Nodex
        newNode = Nodex(key)
        newNode.next = head
        head = newNode
    }

    fun append(key: Int) {
        if (head == null) {
            prepend(key)
            return
        }

        val newNode: Nodex
        var currNode = head
        while (currNode?.next != null)
            currNode = currNode?.next
        newNode = Nodex(key)
        currNode?.next = newNode
    }

    fun printList() {
        var currNode = head
        while (currNode != null) {
            print("${currNode.key}")
            if (currNode.next != null)
                print(" --> ")
            currNode = currNode.next
        }
        println("")
    }


}

fun main(args: Array<String>) {
    val list1 = LinkedList()
    list1.prepend(1)
    list1.prepend(2)
    list1.prepend(3)
    list1.append(4)
    list1.append(5)
    list1.printList()
}




