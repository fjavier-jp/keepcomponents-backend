package fjavierjp.keepcomponents.backend.service;

import java.util.List;

public interface IService<T>
{
	public List<T> index();
	public T show(long id);
	public T store(T t);
	public T update(T t, long id);
	public void delete(long id);
}
