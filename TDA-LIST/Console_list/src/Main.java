import java.util.Scanner;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    // Métodos específicos para lista simplemente enlazada
    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    void prepend(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    void insertByValue(int value, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node current = head;
        while (current != null && current.data != value) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("El valor especificado no se encontró en la lista.");
            return;
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
        if (temp == null) {
            tail = newNode;
        }
    }

    void insertByIndex(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("El índice especificado está fuera de rango.");
            return;
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
        if (temp == null) {
            tail = newNode;
        }
    }

    // Métodos específicos para lista doblemente enlazada
    void appendDoubly(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    void prependDoubly(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    void insertByValueDoubly(int value, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        Node current = head;
        while (current != null && current.data != value) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("El valor especificado no se encontró en la lista.");
            return;
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.prev = current;
        newNode.next = temp;
        if (temp == null) {
            tail = newNode;
        } else {
            temp.prev = newNode;
        }
    }

    void insertByIndexDoubly(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            } else {
                tail = newNode;
            }
            head = newNode;
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("El índice especificado está fuera de rango.");
            return;
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.prev = current;
        newNode.next = temp;
        if (temp == null) {
            tail = newNode;
        } else {
            temp.prev = newNode;
        }
    }

    // Métodos específicos para lista circular
    void appendCircular(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            newNode.next = head;
            tail = newNode;
        }
    }

    void prependCircular(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
        }
    }

    void insertByValueCircular(int value, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
            return;
        }
        Node current = head;
        while (current != null && current.data != value) {
            current = current.next;
            if (current == head) {
                System.out.println("El valor especificado no se encontró en la lista.");
                return;
            }
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
        if (current == tail) {
            tail = newNode;
        }
    }

    void insertByIndexCircular(int index, int data) {
        Node newNode = new Node(data);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            tail.next = newNode;
            return;
        }
        Node current = head;
        int count = 0;
        while (current != null && count < index - 1) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("El índice especificado está fuera de rango.");
            return;
        }
        Node temp = current.next;
        current.next = newNode;
        newNode.next = temp;
        if (current == tail) {
            tail = newNode;
        }
    }

    // Métodos comunes a todas las listas
    void deleteByValue(int value) {
        Node current = head;
        Node prev = null;
        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }
        if (current == null) {
            System.out.println("El valor especificado no se encontró en la lista.");
            return;
        }
        if (current == head) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else if (current == tail) {
            tail = prev;
            tail.next = null;
        } else {
            prev.next = current.next;
        }
    }

    void deleteByIndex(int index) {
        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }
        Node current = head;
        Node prev = null;
        int count = 0;
        while (current != null && count < index) {
            prev = current;
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("El índice especificado está fuera de rango.");
            return;
        }
        if (current == tail) {
            tail = prev;
            tail.next = null;
        } else {
            prev.next = current.next;
        }
    }

    void clear() {
        head = tail = null;
        System.out.println("La lista ha sido vaciada.");
    }

    void display() {
        if (head == null) {
            System.out.println("La lista está vacía.");
            return;
        }
        Node current = head;
        System.out.print("Lista: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
            if (current == head) {
                break;
            }
        }
        System.out.println();
    }

    boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
            if (current == head) {
                break;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList singlyList = new LinkedList();
        LinkedList circularList = new LinkedList();
        LinkedList doublyList = new LinkedList();

        while (true) {
            System.out.println("\nSeleccione una opcion:");
            System.out.println("1. Lista Simple");
            System.out.println("2. Lista Circular");
            System.out.println("3. Lista Doblemente Enlazada");
            System.out.println("4. Salir");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    operateList(singlyList, scanner);
                    break;
                case 2:
                    operateList(circularList, scanner);
                    break;
                case 3:
                    operateList(doublyList, scanner);
                    break;
                case 4:
                    System.out.println("¡Adios!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no válida. Intentelo de nuevo.");
                    break;
            }
        }
    }

    static void operateList(LinkedList list, Scanner scanner) {
        while (true) {
            System.out.println("\nSeleccione una operacion:");
            System.out.println("1. Agregar elemento al inicio");
            System.out.println("2. Agregar elemento al final");
            System.out.println("3. Agregar elemento en una posición especifica basada en su valor");
            System.out.println("4. Agregar elemento en una posición especifica basada en su indice");
            System.out.println("5. Eliminar elemento basado en su valor");
            System.out.println("6. Eliminar elemento basado en su indice");
            System.out.println("7. Vaciar la lista");
            System.out.println("8. Mostrar lista");
            System.out.println("9. Buscar elemento");
            System.out.println("10. Regresar al menu principal");
            int operation = scanner.nextInt();
            int data, value, index;
            switch (operation) {
                case 1:
                    System.out.print("Ingrese el elemento a agregar al inicio: ");
                    data = scanner.nextInt();
                    list.prepend(data);
                    break;
                case 2:
                    System.out.print("Ingrese el elemento a agregar al final: ");
                    data = scanner.nextInt();
                    list.append(data);
                    break;
                case 3:
                    System.out.print("Ingrese el valor despues del cual desea agregar el elemento: ");
                    value = scanner.nextInt();
                    System.out.print("Ingrese el elemento a agregar: ");
                    data = scanner.nextInt();
                    list.insertByValue(value, data);
                    break;
                case 4:
                    System.out.print("Ingrese el índice donde desea agregar el elemento: ");
                    index = scanner.nextInt();
                    System.out.print("Ingrese el elemento a agregar: ");
                    data = scanner.nextInt();
                    list.insertByIndex(index, data);
                    break;
                case 5:
                    System.out.print("Ingrese el elemento a eliminar: ");
                    data = scanner.nextInt();
                    list.deleteByValue(data);
                    break;
                case 6:
                    System.out.print("Ingrese el indice del elemento a eliminar: ");
                    index = scanner.nextInt();
                    list.deleteByIndex(index);
                    break;
                case 7:
                    list.clear();
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.out.print("Ingrese el elemento a buscar: ");
                    data = scanner.nextInt();
                    if (list.search(data)) {
                        System.out.println("El elemento esta presente en la lista.");
                    } else {
                        System.out.println("El elemento no esta presente en la lista.");
                    }
                    break;
                case 10:
                    return;
                default:
                    System.out.println("Opcion no válida. Intentelo de nuevo.");
                    break;
            }
        }
    }
}
