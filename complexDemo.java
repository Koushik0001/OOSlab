class complex 
{
    float real, img;
    complex()
    {
        real = 0;
        img = 0;
    }
    complex(float r)
    {
        img = 0;
        real = r;
    }
    complex(float r, float i)
    {
        img = i;
        real = r;
    }
    complex sum(complex c2)
    {
        complex temp = new complex((real+c2.real),(img+c2.img));
        return temp;
    }
    complex product(complex c2)
    {
        complex temp = new complex(((real * c2.real)-(img*c2.img)),(real*c2.img)+(img*c2.real));
        return temp;
    }
    void display()
    {
        System.out.printf("%f +",real);
        System.out.printf(" (%f)i",img);
    }
}
public class complexDemo 
{
    public static void main(String []args)
    {
        complex c1 = new complex(3,2);
        complex c2 = new complex(4,-2);

        System.out.printf("c1 + c2 = ");
        c1.sum(c2).display();
        System.out.println(" ");
        System.out.printf("c1 * c2 = ");
        c1.product(c2).display();

    }
}
