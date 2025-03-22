package com.primeux.skillflowai.organization.business.ports.in.usecases;

import com.primeux.skillflowai.organization.business.domain.model.User;
import com.primeux.skillflowai.organization.business.domain.model.UserId;
import com.primeux.skillflowai.shared.usecase.ReadEntityUseCase;

public interface ReadUserUseCase extends ReadEntityUseCase<User, UserId> {

}
