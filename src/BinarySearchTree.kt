class Node(val key: Int) {
    var left: Node? = null
    var right: Node? = null
}

class BinarySearchTree() {
    var root: Node? = null

    fun addNode(key: Int) {
        val newNode = Node(key)
        if (root == null)
            root = newNode
        else {
            val lastNode = search(key).second
            if (lastNode != null) {
                if (key < lastNode.key)
                    lastNode.left = newNode
                else
                    lastNode.right = newNode
            }
        }
    }

    fun search(key: Int): Pair<Boolean, Node?> {
        var currNode = root
        var prevNode: Node? = null
        while (currNode != null) {
            prevNode = currNode
            if (key == currNode.key)
                return Pair(true, currNode)
            else
                if (key < currNode.key)
                    currNode = currNode.left
                else
                    currNode = currNode.right
        }
        return Pair(false, prevNode)
    }

    fun printInorder() {
        fun printInorder(currNode: Node?) {
            if (currNode != null) {
                printInorder(currNode.left)
                print("${currNode.key} ")
                printInorder(currNode.right)
            }
        }
        printInorder(root)
        println("")
    }

    fun printLevelOrder() {
        val q = mutableListOf(root)
        var currNode: Node?

        while (q.isNotEmpty()) {
            currNode = q[0]
            print("${currNode?.key} ")
            q.removeAt(0)
            if (currNode?.left != null)
                q.add(currNode?.left)
            if (currNode?.right != null)
                q.add(currNode?.right)
        }
        println("")
    }

}

fun main(args: Array<String>) {
    val bst = BinarySearchTree()
    bst.addNode(4)
    bst.addNode(2)
    bst.addNode(6)
    bst.addNode(1)
    bst.addNode(3)
    bst.addNode(5)
    bst.addNode(7)

    bst.printInorder()
    bst.printLevelOrder()
}