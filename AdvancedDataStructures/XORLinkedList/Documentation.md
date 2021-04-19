Ordinary Representation:
Node A:
prev = NULL, next = add(B) // previous is NULL
Node B:
prev = add(A), next = add(C) 
Node C:
prev = add(B), next = add(D)
Node D:
prev = add(C), next = NULL

XOR List Representation:
Let us call the address variable in XOR representation npx(XOR of next and prev).

Node A:
npx = 0 XOR add(B) 
Node B:
npx = add(A) XOR add(C)
Node C:
npx = add(B) XOR add(D)
Node D:
npx = add(C)

In the following code, insert() function inserts a new node in the beginning. We need to change the head pointer of Linked List, that is why a double pointer is used. Let us first discuss few things again that have been discussed in the previous post. We store XOR of next and previous nodes with every node and we call it npx, which is the only address member we have with every node. When we insert a new node at the beginning, npx of new node will always be XOR of NULL and current head. And npx of the current head must be changed to XOR of new node and node next to the current head.
printList() traverses the list in forward direction. It prints data values from every node. To traverse the list, we need to get pointer to the next node at every point. We can get the address of next node by keeping the track of current node and previous node. If we do XOR of curr->npx and prev, we get the address of next node.
