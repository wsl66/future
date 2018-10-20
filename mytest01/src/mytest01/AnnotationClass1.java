package mytest01;


@MyAnotation1(name="张三", age = 1)
public class AnnotationClass1 {
	public static void main(String[] args) {
		Class<AnnotationClass1> clazz = AnnotationClass1.class;
		MyAnotation1 annotation = clazz.getAnnotation(MyAnotation1.class);
		System.out.println(annotation.name());
		System.out.println(annotation.color());
	}
}
