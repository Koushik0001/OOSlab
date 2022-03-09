class Complex
{
	float img, real;
	Complex()
	{
		img = 0;
		real = 0;
	}
	Complex(float r)
	{
		img = 0;
		real = r;
	}
	Complex(float r, float i)
	{
		real = r;
		img = i;
	}
	Complex add(Complex c2)
	{
		Complex temp = new Complex((real+c2.real),(img+c2.img));
		return temp;
	}
	Complex product(Complex c2)
	{
		Complex temp = new Complex((real*c2.real - img*c2.img),(real*c2.img + c2.real *img));
		return temp;
	}
	void display()
	{
		System.out.printf("%f + (%f)i",real,img);
	}
}
class ComplexDemo
{
	public static void main(String []args)
	{
		Complex c1 = new Complex(3,2);
		Complex c2 = new Complex(4,-2);
		 
		System.out.printf("c1 + c2 = ");		
		c1.add(c2).display();
		
		 System.out.println();
		 System.out.printf("c1 * c2 = ");
		c1.product(c2).display();
		 System.out.println();

	}
}
