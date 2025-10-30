void main(String[] args) {
    int [] numbers = new int [args.length];
    for (int i = 0; i < args.length; i++) {
        numbers[i] = Integer.parseInt(args[i]);
    }

    for (int i = 0; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[i] > numbers[j]) {
                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }
    }

    for (int n : numbers){
        IO.print(n + " ");
    }

}
