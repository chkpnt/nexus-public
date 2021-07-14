/*
 * Sonatype Nexus (TM) Open Source Version
 * Copyright (c) 2008-present Sonatype, Inc.
 * All rights reserved. Includes the third-party code listed at http://links.sonatype.com/products/nexus/oss/attributions.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License Version 1.0,
 * which accompanies this distribution and is available at http://www.eclipse.org/legal/epl-v10.html.
 *
 * Sonatype Nexus (TM) Professional Version is available from Sonatype, Inc. "Sonatype" and "Sonatype Nexus" are trademarks
 * of Sonatype, Inc. Apache Maven is a trademark of the Apache Software Foundation. M2eclipse is a trademark of the
 * Eclipse Foundation. All other trademarks are the property of their respective owners.
 */
package org.sonatype.nexus.testsuite.testsupport.fixtures

import javax.annotation.Nonnull

import org.sonatype.nexus.repository.Repository
import org.sonatype.nexus.repository.config.Configuration
import org.sonatype.nexus.repository.config.WritePolicy

import groovy.transform.CompileStatic;

/**
 * Factory for R {@link Repository} {@link Configuration}
 */
@CompileStatic
trait RRepoRecipes
    extends ConfigurationRecipes
{
  @Nonnull
  Repository createRProxy(final String name,
                          final String remoteUrl)
  {
    createRepository(createProxy(name, 'r-proxy', remoteUrl))
  }

  @Nonnull
  Repository createRHosted(final String name) {
    createRepository(createHosted(name, 'r-hosted'))
  }

  @Nonnull
  Repository createRHosted(final String name, final WritePolicy writePolicy) {
    createRepository(createHosted(name, 'r-hosted', writePolicy.toString()))
  }

  @Nonnull
  Repository createRGroup(final String name, final String... members) {
    createRepository(createGroup(name, 'r-group', members))
  }

  abstract Repository createRepository(final Configuration configuration)
}