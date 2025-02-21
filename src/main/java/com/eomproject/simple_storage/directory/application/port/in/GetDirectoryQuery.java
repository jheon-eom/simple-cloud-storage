package com.eomproject.simple_storage.directory.application.port.in;

import com.eomproject.simple_storage.directory.domain.Directory;

public interface GetDirectoryQuery {

    Directory getDirectory(Long directoryId, Long loginUserId);
}
