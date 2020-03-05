/*******************************************************************************
 * Copyright (c) 2019, 2020 Contributors to the Eclipse Foundation
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package org.eclipse.hono.deviceregistry.service.credentials;

import org.eclipse.hono.service.credentials.CredentialsService;
import org.eclipse.hono.service.credentials.EventBusCredentialsAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * A default event bus based service implementation of the {@link CredentialsService}.
 * <p>
 * This wires up the actual service instance with the mapping to the event bus implementation. It is intended to be used
 * in a Spring Boot environment.
 * @deprecated This class will be removed in future versions as AMQP endpoint does not use event bus anymore.
 *             Please use {@link org.eclipse.hono.service.credentials.AbstractCredentialsAmqpEndpoint} based implementation in the future.
 */
@Component
@Deprecated(forRemoval = true)
public final class AutowiredCredentialsAdapter extends EventBusCredentialsAdapter {

    private CredentialsService service;

    @Autowired
    @Qualifier("backend")
    public void setService(final CredentialsService service) {
        this.service = service;
    }

    @Override
    protected CredentialsService getService() {
        return this.service;
    }

}
