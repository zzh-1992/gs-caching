/*
 *Copyright @2022 Grapefruit. All rights reserved.
 */

package com.example.caching;

public interface BookRepository {

	Book getByIsbn(String isbn);
}
