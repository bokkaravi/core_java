public class ArrayCopying {
    public static void main(String[] args) {
        char[] array = {'i','a','m','r','a','v','i'};
        char[] copyTo = new char[5];

        System.arraycopy(array,1,copyTo,0,5);

        System.out.println(String.valueOf(copyTo));



                int[][] a  ={{1,3,4},{3,4,5}};
                int[][] b  ={{1,3,4},{3,4,5}};



//creating another matrix to store the sum of two matrices
                int[][] c  =new int[2][3];

//adding and printing addition of 2 matrices
                for(int i=0;i<2;i++){
                    for(int j=0;j<3;j++){
                        c[i][j] =a[i][j] +b[i][j] ;
                        System.out.print(c[i][j] +" ");
                    }
                    System.out.println();//new line
                }

        int[][] aa  ={{1,1,1},{2,2,2},{3,3,3}};
        int[][] bb  ={{1,1,1},{2,2,2},{3,3,3}};

    }
}
