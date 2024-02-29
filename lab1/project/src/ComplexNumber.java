public class ComplexNumber {
    public double real;
    public double imaginary;
    public ComplexNumber(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumber Add(ComplexNumber other)
    {
        return new ComplexNumber(this.real + other.real, this.imaginary + other.imaginary);
    }

    public ComplexNumber Product(ComplexNumber other)
    {
        return new ComplexNumber(this.real * other.real - this.imaginary * other.imaginary, this.real * other.imaginary + this.imaginary * other.real);
    }

    public double GetReal()
    {
        return this.real;
    }
    public double GetImaginary()
    {
        return this.imaginary;
    }
}
