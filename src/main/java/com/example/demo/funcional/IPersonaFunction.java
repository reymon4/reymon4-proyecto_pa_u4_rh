package com.example.demo.funcional;

@FunctionalInterface
public interface IPersonaFunction<R,T> { //REtorno y argumento
	public R aplicar(T arg1); 

}
