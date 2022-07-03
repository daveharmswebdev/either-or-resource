package com.eitheror.eitherorresource.repositories;

import com.eitheror.eitherorresource.domain.Option;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User: Dave Harms
 * Date: 7/3/22
 * Time: 2:42 PM
 */
public interface OptionRepository extends JpaRepository<Option, Long> {
}
