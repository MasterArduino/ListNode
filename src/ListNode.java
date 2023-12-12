public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // Метод для вывода элементов связанного списка
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    // Метод для слияния узлов между последовательными нулями
    public static ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(); // Создаем фиктивный узел
        ListNode current = dummy; // Указатель на текущий узел
        int sum = 0; // Переменная для хранения суммы значений узлов

        while (head != null) {
            if (head.val == 0) { // Если встречаем ноль
                if (sum != 0) { // Если сумма не равна нулю, добавляем новый узел с суммой
                    current.next = new ListNode(sum);
                    current = current.next;
                    sum = 0; // Обнуляем сумму для следующей последовательности
                }
            } else {
                sum += head.val; // Суммируем значения узлов
            }
            head = head.next;
        }

        if (sum != 0) { // Обрабатываем последнюю последовательность после последнего нуля
            current.next = new ListNode(sum);
        }

        return dummy.next; // Возвращаем новый связанный список без нулей
    }

    public static void main(String[] args) {
        // Пример 1
        ListNode list1 = new ListNode(0, new ListNode(2, new ListNode(2,
                new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))));
        System.out.println("Input 1:");
        printList(list1);
        ListNode result1 = mergeNodes(list1);
        System.out.println("Output 1:");
        printList(result1);
        System.out.println();

        // Пример 2
        ListNode list2 = new ListNode(0, new ListNode(2, new ListNode(0, new ListNode(1,
                new ListNode(0, new ListNode(3, new ListNode(3, new ListNode(0))))))));
        System.out.println("Input 2:");
        printList(list2);
        ListNode result2 = mergeNodes(list2);
        System.out.println("Output 2:");
        printList(result2);
    }
}
