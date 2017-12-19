package com;
public class SingleLinkedList {
	Node head;
	public void printList()
	{
		Node node=head;
		while(node!=null)
		{
			System.out.print(node.data+" ");
			node=node.next;
		}
		System.out.println();
	}
	public void addNodeatFront(int data)
	{
		Node frontNode=new Node(data);
		frontNode.next=head;
		head=frontNode;
	}
	
	public void addNodeinBetween(int data,Node prevNode) // add a node between two Nodes
	{
		
		// if head is null - nothing is there in linkedlist
		if(prevNode==null)
		{
			System.out.println("previoud node can not be null");
			return;
		}
		
		// write some code for validation
		Node newNode=new Node(data);
		Node temp=prevNode.next;
		prevNode.next=newNode;
		newNode.next=temp;
		
	}
	public void addNodeatLast(int data)
	{
		if(head==null)
		{
			System.out.println("No LinkedList");
			return;  // no linkedlist exist
		}
		else{
			Node node=head;
			while(node.next!=null)   // trick is here ; choose the prev Node of last Node
			{
				node=node.next;
			}
			//create the last Node
			Node lastNode=new Node(data);
			node.next=lastNode;
			
		}
			
	}
	public int noOfNode() // this function return Number of Nodes in a LinkedList
	{
		Node node=head;
		int count=0;
		while(node!=null)
		{
			count=count+1;
			node=node.next;
		}
		return count;
	}
	
	public void deleteNode(int key) // Given a Key, Delete Node
	{
		
		if(head==null) // if there is no node in linkedlist
		{
			return;
		}
		
		Node node=head;
		Node prevNode=null;
		// if head node contains the key and it has to be deleted
		if(node!=null && node.data==key)
		{
			head=node.next;
			return;
		}
		while(node.data!=key)
		{
			prevNode=node;
			node=node.next;
		}
		
		if(node==null)  //key is not present in List
			return; 
		//unlink the node from the Linkedlist
		prevNode.next=node.next;
		
	}
	public Node[] returnPrevNode(int position)
	{
		Node node=head;
		Node pNode[]=new Node[2];
		int c=0;
		while(node!=null)
		{
			c+=1;
			if(c==position-1)
			{
				pNode[0]=node;
				pNode[1]=node.next;
				break;
			}
			node=node.next;
		}
		return pNode;
		
	}
	
	public void deleteNodeatPosition(int p)
	{
		//get prevNode
		
		Node[] myPrevNode=returnPrevNode(p);
		if(myPrevNode[0]==null)
		{
			System.out.println("deletion not possible because prevnode is null");
			return;
		}
		else{
			
			Node prevNode=myPrevNode[0];
			Node currNode=myPrevNode[1];
			prevNode.next=currNode.next;
			
		}
	}
	public boolean searchNode(int key) // although we have written the same code in delete a node method
	{
		Node node=head;
		boolean res=false;
		while(node!=null)
		{
			if(node.data==key)
			{
				res=true;
				break;
			}
			node=node.next;
		}
		return res;
	}
	public static void main(String args[])
	{
		SingleLinkedList list=new SingleLinkedList();
		Node node1=new Node(10);
		Node node2=new Node(20);
		Node node3=new Node(30);
		list.head=node1;
		node1.next=node2;
		node2.next=node3;
		//print the list
		list.printList();
		//add a node at front
		System.out.println("After adding a node-222 at Front");
		list.addNodeatFront(222);
		list.printList();
		System.out.println("Add a Node in Between two Nodes");
		list.addNodeinBetween(555, node2);
		list.printList();
		System.out.println("Add Node at Last");
		list.addNodeatLast(1001);
		list.printList();
		System.out.println("Given a Key,Delete a Node: {Where key is node.data}");
		list.deleteNode(30);
		list.printList();
		System.out.println("Delete a Node at a specific Position");
		list.deleteNodeatPosition(5);
		list.printList();
		System.out.println("Number of Node in our LinkedList- "+list.noOfNode());
		System.out.println("search if 300 is there in linkedlist- "+list.searchNode(300));
		System.out.println("search if 20 is there in linkedlist- "+list.searchNode(20));
		
		
	}
}
