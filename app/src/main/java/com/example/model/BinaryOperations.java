package com.example.model;
import com.example.Enum.MathOperation;
import com.example.Enum.NumericType;
import com.example.operations.IBinaryOperations;
import com.example.operations.Lambda;

public class BinaryOperations<T extends Number> implements IBinaryOperations<Long>
{
    public  Number x;
    public  Number y;
    private MathOperation operation;
    private NumericType type;
    public BinaryOperations() {}
    @Override
    public Long plus(Long x, Long y)
    {
        return null;
    }

    @Override
    public Long minus(Long x, Long y)
    {
        return null;
    }

    @Override
    public Long plus_minus(Long x, Long y)
    {
        return null;
    }

    @Override
    public Long percent(Long x, Long y, MathOperation operation, NumericType type)
    {
        return null;
    }

    /**
     * A method for type verification
     * Верификация входного типа
     * @param x
     * @param y
     * @param type
     */
    public <T extends Number> void CheckType(T x , T y, NumericType type)
    {
        if(type == NumericType.LONG)
        {
            this.x = x.longValue();
            this.y = y.longValue();
        }else if (type == NumericType.DOUBLE) {
            this.x = x.doubleValue();
            this.y = y.doubleValue();
        }else{
            throw new ArithmeticException("Incorrect type");
        }
    }

    /**
     * A method for calculations
     * @param x
     * @param y
     * @param operation
     * @return
     */
    public T operate(T x, T y, MathOperation operation) {
        switch (operation) {
            case PLUS:
                break;
            case MINUS:

                break;
            case MULTIPLY:

                break;
            case DIVIDE:

                break;
            case PERCENT:
                break;
            default:
                throw new IllegalArgumentException("Unsupported operation: " + operation);
        }
        return null;
    }
}
