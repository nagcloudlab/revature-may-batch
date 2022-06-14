class Todo {
    static nextId: number = 0;
    public id: number;
    public title: string
    public completed: boolean
    constructor(title: string) {
        Todo.nextId++;
        this.id = Todo.nextId
        this.title = title;
        this.completed = false;
    }
}

export { Todo }