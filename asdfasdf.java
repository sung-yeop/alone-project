public class asdfasdf {
    private long n;
    private long result = 0;

    public asdfasdf(long n){
        this.n = n;
    }

    public long calcPow(long a, long n){
        if(n == 0){
            return 1;
        }else{
            long temp = calcPow(a, n/2)%this.n;
            if(n%2 == 0) return temp*temp%this.n;
            else return temp*temp*a%this.n;
        }
    }

    private void primality_test(long a, long n, int sign){
        if(a>n){
            a = a%n;
        }
        if(a==2){
            if(n%8 == 1 || n%8 == 7){ //변경된 부분 추가
                if(sign == 1){
                    this.result = 1;
                    return;
                } else if(sign == -1){
                    this.result = (-1) + this.n;
                    return;
                }
                return;
            } else if(n%8 == 3 || n%8 == 5){
                if(sign == 1){
                    this.result = (-1) + this.n;
                    return;
                } else if(sign == -1){
                    this.result = 1;
                    return;
                }
            }
        } else if(a == 1){
            if(sign == 1){
                this.result = 1;
                return;
            } else if(sign == -1){
                this.result = (-1) + this.n;
                return;
            }
        } else{
            int exp = exp(a);
            if(exp != 0){
                for(int i=0; i<exp; i++){
                    a = a/2;
                }
                if((n%8 == 3 || n%8 == 5) && exp%2 != 0){
                    sign = sign*(-1);
                }
            }

            if(a==2){
                if(n%8 == 1 || n%8 == 7){
                    if(sign == 1){
                        this.result = 1;
                        return;
                    } else if(sign == -1){
                        this.result = (-1) + this.n;
                        return;
                    }
                    return;
                } else if(n%8 == 3 || n%8 == 5){
                    if(sign == 1){
                        this.result = (-1) + this.n;
                        return;
                    } else if(sign == -1){
                        this.result = 1;
                        return;
                    }
                }
            } else if(a == 1){
                if(sign == 1){
                    this.result = 1;
                    return;
                } else if(sign == -1){
                    this.result = (-1) + this.n;
                    return;
                }
            }

            if(a%4 == 3 && n%4 == 3) {
                sign*=(-1);
                primality_test(n, a, sign);
            } else{
                primality_test(n, a, sign);
            }
        }
    }

    private int exp(long a){
        int result = 0;
        while(a % 2 == 0){
            result++;
            a = a/2;
            if(a == 2){
                result++;
                break;
            }
        }
        return result;
    }

    private int sign_select(int exp, int sign, int flag){
        int result = 0;
        if(exp%2 == 0){
            result = sign;
        } else{
            result = sign * flag;
        }
        return result;
    }

    public static void print(long[] array){
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args){
        long n = 30000000;
        long[] result_array = new long[10];
        int k = 0;

        while(true){
            asdfasdf as = new asdfasdf(n);
            boolean flag = true;

            for(int i=1; i<101; i++){
                as.primality_test(i, n, 1);
                long result = as.calcPow(i, (n-1)/2);
                if(result != as.result){
                    flag = false;
                    break;
                }
            }
            if(flag){
                result_array[k++] = n;
            }
            n++;
            if(k == 10){
                break;
            }
        }
        print(result_array);
    }
}
