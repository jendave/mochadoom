package net.sourceforge.mochadoom.tests;

import java.lang.reflect.Method;

import net.sourceforge.mochadoom.menu.FixedFloat;
import net.sourceforge.mochadoom.menu.fixed_t;

/** A simple benchmark proving how using reflection is slower than both simply switching
 *  on a status flag, or using "invokable" objects. This affected the choice of invokable objects
 *  and simple switching whenever Doom used function pointers.
 *  
 */

public class TestReflection {

    /**
     * @param args
     * @throws Exception
     * @throws
     */
    public static void main(String[] args)
            throws Exception {
        int TESTS = 50000000;

        // "function pointer" to fadd
        Method fadd = fixed_t.class.getDeclaredMethod("add", fixed_t.class);
        Method fmul =
            fixed_t.class.getDeclaredMethod("FixedMul", fixed_t.class);

        Operation fadd2=new Add();
        Operation fmul2=new Mul();
        Operation todo;
        
        fixed_t a = new fixed_t(FixedFloat.toFixed(1.0));
        fixed_t b = new fixed_t(FixedFloat.toFixed(1.1));

        
        
        Method operation = fadd;

        {
            long ta = System.nanoTime();
            for (int i = 0; i < TESTS; i++) {
                operation.invoke(a, b);
            }

            long tb = System.nanoTime();
            System.out.println("Adding with reflection :"+(tb - ta));
        }
        System.out.println(FixedFloat.toDouble(a.val));

        a = new fixed_t(FixedFloat.toFixed(1.0));

        operation = fmul;

        {
            long ta = System.nanoTime();
            for (int i = 0; i < TESTS; i++) {
                operation.invoke(a, b);
            }

            long tb = System.nanoTime();
            System.out.println("Multiplying with reflection :"+(tb - ta));
        }
        System.out.println(FixedFloat.toDouble(a.val));

        /** add=0, mul=1 */
        int op = 0;

        a = new fixed_t(FixedFloat.toFixed(1.0));

        {
            long ta = System.nanoTime();
            for (int i = 0; i < TESTS; i++) {
                switch (op) {
                case 0:
                    a.add(b);
                    break;
                case 1:
                    a.FixedMul(b);
                    break;
                }
            }

            long tb = System.nanoTime();
            System.out.println("Adding with switching :"+(tb - ta));
        }
        System.out.println(FixedFloat.toDouble(a.val));

        
          op=1;
        a = new fixed_t(FixedFloat.toFixed(1.0));

        {
            long ta = System.nanoTime();
            for (int i = 0; i < TESTS; i++) {
                switch (op) {
                case 0:
                    a.add(b);
                case 1:
                    a.FixedMul(b);
                }
            }

            long tb = System.nanoTime();
            System.out.println("Multiplying with switching :"+(tb - ta));
        }
        System.out.println(FixedFloat.toDouble(a.val));
        
        a = new fixed_t(FixedFloat.toFixed(1.0));
        
        todo=fadd2;

        {
            long ta = System.nanoTime();
            for (int i = 0; i < TESTS; i++) {
                todo.invoke(a,b);
            }

            long tb = System.nanoTime();
            System.out.println("Adding with invokable object :"+(tb - ta));
        }
        System.out.println(FixedFloat.toDouble(a.val));
        
        a = new fixed_t(FixedFloat.toFixed(1.0));
        
        todo=fmul2;

        {
            long ta = System.nanoTime();
            for (int i = 0; i < TESTS; i++) {
                todo.invoke(a,b);
            }

            long tb = System.nanoTime();
            System.out.println("Multiplying with invokable object :"+(tb - ta));
        }
        System.out.println(FixedFloat.toDouble(a.val));
        
        operation = fadd;

        {
            long ta = System.nanoTime();
            for (int i = 0; i < TESTS; i++) {
                operation.invoke(a, b);
            }

            long tb = System.nanoTime();
            System.out.println("Adding with reflection 2:"+(tb - ta));
        }
        System.out.println(FixedFloat.toDouble(a.val));

        a = new fixed_t(FixedFloat.toFixed(1.0));

        operation = fmul;

        {
            long ta = System.nanoTime();
            for (int i = 0; i < TESTS; i++) {
                operation.invoke(a, b);
            }

            long tb = System.nanoTime();
            System.out.println("Multiplying with reflection 2:"+(tb - ta));
        }
        System.out.println(FixedFloat.toDouble(a.val));
        
        
    }

}
