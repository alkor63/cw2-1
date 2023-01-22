package CourseWork2code;

import java.time.LocalDate;

public class OneTimeTask extends Task{
//        implements Comparable

        public OneTimeTask(String title, Type type, String description) {
            super(title, type, description);

        }
@Override
public boolean appearsIn(LocalDate d){
return true;
}

}
