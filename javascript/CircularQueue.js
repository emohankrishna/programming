class CircularQueue {
    constructor(size) {
        this.circularQueue = [];
        this.circularQueue.length = size;
        this.front = -1;
        this.rear = -1;
        this.size = size;
    }
    enQueue(data) {
        if ((this.rear + 1) % this.size == this.front) {
            console.log("Queue is Full")
            return false
        }
        else if (this.front == -1) {
            this.front = 0;
            this.rear = 0;
            this.circularQueue[this.rear] = data;
        }
        else {
            this.rear = (this.rear + 1) % this.size
            this.circularQueue[this.rear] = data;
        }
        return true;
    }

    deQueue() {
        if (this.front == -1) {
            console.log("Queue is empty");
        }
        else if (this.front == this.rear) {
            let temp = this.circularQueue[this.front];
            this.circularQueue[this.front] = null;
            this.front = -1;
            this.rear = -1;
            return temp;
        }
        else {
            let temp = this.circularQueue[this.front];
            this.circularQueue[this.front] = null;
            this.front = this.front + 1 % this.size;
            return temp;
        }
    }
}

const queue = new CircularQueue(5);
queue.enQueue(10);
queue.enQueue(20);
queue.enQueue(30);
queue.enQueue(40);
queue.enQueue(50);
queue.enQueue(60);
console.log(queue.circularQueue);
console.log(queue.deQueue());
console.log(queue.deQueue());
console.log(queue.deQueue());
console.log(queue.deQueue());
console.log(queue.deQueue());
console.log(queue.deQueue());
queue.enQueue(50);
console.log(queue.circularQueue);
