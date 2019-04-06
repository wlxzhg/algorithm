public class Main {
	public static void main(String[] args) {
		RandomListNode l1 = new RandomListNode(1);
		RandomListNode l2 = new RandomListNode(2);
		RandomListNode l3 = new RandomListNode(3);
		RandomListNode l4 = new RandomListNode(4);
		RandomListNode l5 = new RandomListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		l1.random = l3;
		l2.random = l5;
		l3.random = null;
		l4.random = l2;
		l5.random = null;

		RandomListNode newHead = (new Main()).Clone(l1);
		l1.label = -1;

		for(RandomListNode p = newHead; p != null; p = p.next) {
			System.out.println(p + "\t" + p.random);
		}

		System.out.println("-----------------");

		for(RandomListNode p = l1; p != null; p = p.next) {
			System.out.println(p + "\t" + p.random);
		}
	}

	public RandomListNode Clone(RandomListNode pHead) {
		if(pHead == null)
			return null;
		RandomListNode p = pHead;
		while(p != null) {
			RandomListNode next = p.next;
			p.next = new RandomListNode(p.label);
			p.next.next = next;
			p = next;
		}

		p = pHead;
		while(p != null) {
			RandomListNode next = p.next;
			RandomListNode random = p.random;
			if(random == null)
				next.random = null;
			else
				next.random = random.next;
			p = p.next.next;
		}

		RandomListNode dummy1 = new RandomListNode(-1);
		RandomListNode dummy2 = new RandomListNode(-1);
		RandomListNode p1 = dummy1,p2 = dummy2;
		p = pHead;

		while(p != null) {
			p1.next = p;
			p2.next = p.next;

			p1 = p1.next;
			p2 = p2.next;
			p = p.next.next;
		}
		p1.next = null;
		p2.next = null;
		return dummy2.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    public String toString() {
    	return label + "";
    }
}