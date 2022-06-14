import { Todo } from "./todo.model";

const TODO_FILTERS: any = {
    ALL: () => true,
    ACTIVE: (todo: Todo) => !todo.completed,
    COMPLETED: (todo: Todo) => todo.completed
}

export { TODO_FILTERS }
