package Threads;

public class ThreadCreationWays {

    public static void main(String[] args) {
        //ilk çalışan thread main threaddir. kontrol edilişi aşağıdaki gibidir.
        System.out.println("Current Thread : " + Thread.currentThread().getName());
        MyThread thread1 = new MyThread();
        thread1.start();//thread sınıfında run() metodunda yazılanlar işlenmeye başlar.

        // thread1.run(); diyerek de çağırdığımızda method yine çalışıyor, start() ile çağırmamız
        //arasındaki fark : run() ile çağırıldığında thread değişmez sadece method çalışır.
        //start() da ise önce thread ayağa kalkar daha sonra işçindeki run() metodu çalışır.
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        thread2.start();

        //İsimsiz olarak thread oluşturma, annonymous (Interface)

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Current Thread : " + Thread.currentThread().getName());
                System.out.println("Bu anonymous class yoluyla oluşturulan iş parçacığıdır. ");


            }
        });
        thread3.setName("Thread3");
        thread3.start();

        //isimsiz olarak thread oluşturma 2. yol

        Thread thread4 = new Thread(() -> {

            System.out.println("lambda ile yazıldı.");


        });
        thread4.start();

    }
    //1. yol : Thread classını extend ederek

}

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("MyThread threadi çalışıyor.");
    }
}


//2. yol : Runnable Interface i implement ederek
class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnabel Interface'den türetilen thread çalıştı.");
    }
}