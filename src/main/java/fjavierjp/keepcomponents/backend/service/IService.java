package fjavierjp.keepcomponents.backend.service;

import java.util.List;

import org.springframework.data.domain.Page;

public interface IService<T>
{
	public List<T> index();
	public Page<T> search(int page, int size, String search);
	public T show(long id);
	public T store(T t);
	public T update(T t, long id);
	public void delete(long id);
}
