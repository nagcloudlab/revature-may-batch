package com.example.exception;


//---------------------------------------------------------
// Driver , a class which interact ( read /write ) with external sources  ( database )
//---------------------------------------------------------

/**
 * authorization : Nag
 */

class Driver implements AutoCloseable {
    public void init() {
        // intialize the driver to external sources
        System.out.println("init");
    }

    public void readOrWrite() {
        System.out.println("read / write ");
        boolean isNetworkError = false;
        if (isNetworkError)
            throw new IllegalStateException("network error while connecting to database");
    }

    public void close() {
        System.out.println("close()");
    }

}


public class Try_Catch_Finally_Ex2 {
    public static void main(String[] args) {

        // You
        Driver driver = new Driver();
        try(driver) {
            driver.init();
            driver.readOrWrite();
            return;
//            driver.close();
        } catch (IllegalStateException e) {
//            driver.close();
            System.out.println("Ex - " + e.getMessage());
        }
//        finally {
//            // cleanup
//            driver.close();
//            /*
//                e.g
//                - close file pointers
//                - close db connection
//                - close n/w sockets
//                - delete tmp files
//             */
//        }

    }
}
