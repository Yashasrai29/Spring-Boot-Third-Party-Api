//package com.example.api.model;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//import java.util.Set;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//public class filterCopy {
//    @GetMapping( "/filters" )
//    public ResponseEntity<PaginationOutput<OrganizationOutput>> getOrganizationsByFilter(
//            @RequestParam( name = "organizationName", required = false ) String name,
//            @RequestParam( name = "sectorIds", required = false ) List<String> sectorIds,
//            @RequestParam( name = "subSectorIds", required = false ) List<String> subSectorIds,
//            @RequestParam( required = false, defaultValue = PAGE_NUMBER ) String pageNumber,
//            @RequestParam( required = false, defaultValue = PAGE_SIZE ) String pageSize ) {
//        return new ResponseEntity<>(
//                organizationFacade.getOrganizationsByFilter( name, sectorIds, subSectorIds, pageNumber, pageSize ),
//                HttpStatus.OK );
//    }
//
//    private Sector getSectorById( String sectorId ) {
//        // Converts all the String id to UUID and gets  the Sectors with matching id
//        return sectorService.getBySectorId( UUID.fromString( sectorId ) );
//
//    }
//
//    private SubSector getSubSectorById( String subSectorId ) {
//        // Converts all the String id to UUID and gets  the SubSector with matching id
//        return subSectorService.getBySubSectorId( UUID.fromString( subSectorId ) ).get();
//    }
//    @Override
//    public PaginationOutput<OrganizationOutput> getOrganizationsByFilter( final String name, final List<String> sectorIds,
//                                                                          final List<String> subSectorIds, final String pageNumber, final String pageSize ) {
//        if( name == null && sectorIds == null && subSectorIds == null ) {
//            throw new OrganizationException( "Please Enter the any of the following Options" );
//        }
//        //if( sectorIds == null ) {
//        //  throw new OrganizationException( "sectorId cannot be empty " );
//        //}
//        //if( subSectorIds == null ) {
//        //  throw new OrganizationException( "subSectorId cannot be empty " );
//        //}
//        if( name != null && sectorIds == null && subSectorIds == null ) {
//            PageRequest page = PageRequest.of( Integer.parseInt( pageNumber ), Integer.parseInt( pageSize ) );
//            var organizations = organizationService.getOrganizationWithName( page, name );
//            return PageMapper.INSTANCE.response( organizations,
//                    organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList() );
//        }
//
//        if( name == null && sectorIds != null && subSectorIds == null ) {
//            Set<Sector> filteredSector = sectorIds.stream().map(e -> getSectorById( e ) ).collect( Collectors.toSet() );
//            PageRequest page = PageRequest.of( Integer.parseInt( pageNumber ), Integer.parseInt( pageSize ) );
//            var organizations = organizationService.getOrganizationWithSectorID( page, filteredSector );
//            return PageMapper.INSTANCE.response( organizations,
//                    organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList() );
//
//        }
//
//        if( name != null && sectorIds != null && subSectorIds == null ) {
//            Set<Sector> filteredSector = sectorIds.stream().map( e -> getSectorById( e ) ).collect( Collectors.toSet() );
//            PageRequest page = PageRequest.of( Integer.parseInt( pageNumber ), Integer.parseInt( pageSize ) );
//            var organizations = organizationService.getOrganizationWithNameAndSectorID( page, name, filteredSector );
//            return PageMapper.INSTANCE.response( organizations,
//                    organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList() );
//
//        }
//
//        if( name == null && sectorIds == null && subSectorIds != null ) {
//            Set<SubSector> filteredSubSector = subSectorIds.stream().map( e -> getSubSectorById( e ) )
//                    .collect( Collectors.toSet() );
//            PageRequest page = PageRequest.of( Integer.parseInt( pageNumber ), Integer.parseInt( pageSize ) );
//
//            var organizations = organizationService.getOrganizationWithSubSectorId( page, filteredSubSector );
//            return PageMapper.INSTANCE.response( organizations,
//                    organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList() );
//        }
//        if( name != null && sectorIds == null && subSectorIds != null ) {
//
//            Set<SubSector> filteredSubSector = subSectorIds.stream().map( e -> getSubSectorById( e ) )
//                    .collect( Collectors.toSet() );
//            PageRequest page = PageRequest.of( Integer.parseInt( pageNumber ), Integer.parseInt( pageSize ) );
//
//            var organizations = organizationService.getOrganizationWithNameAndSubSectorId( page, name, filteredSubSector );
//
//            //return organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList();
//            return PageMapper.INSTANCE.response( organizations,
//                    organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList() );
//        }
//
//        if( name == null && sectorIds != null && subSectorIds != null ) {
//            Set<Sector> filteredSector = sectorIds.stream().map( e -> getSectorById( e ) ).collect( Collectors.toSet() );
//            Set<SubSector> filteredSubSector = subSectorIds.stream().map( e -> getSubSectorById( e ) )
//                    .collect( Collectors.toSet() );
//            PageRequest page = PageRequest.of( Integer.parseInt( pageNumber ), Integer.parseInt( pageSize ) );
//
//            var organizations = organizationService.getOrganizationWithSectorIDAndSubSectorId( page, filteredSector,
//                    filteredSubSector );
//
//            //return organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList();
//            return PageMapper.INSTANCE.response( organizations,
//                    organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList() );
//        }
//
//        if( name != null && sectorIds != null && subSectorIds != null ) {
//            Set<Sector> filteredSector = sectorIds.stream().map( e -> getSectorById( e ) ).collect( Collectors.toSet() );
//            Set<SubSector> filteredSubSector = subSectorIds.stream().map( e -> getSubSectorById( e ) )
//                    .collect( Collectors.toSet() );
//            PageRequest page = PageRequest.of( Integer.parseInt( pageNumber ), Integer.parseInt( pageSize ) );
//
//            var organizations = organizationService.getOrganizationsWithFilter( page, name, filteredSector,
//                    filteredSubSector );
//
//            //return organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList();
//            return PageMapper.INSTANCE.response( organizations,
//                    organizations.stream().map( OrganizationMapper.INSTANCE::mapOrganizationModelToDto ).toList() );
//        }
//
//        return null;
//    }
//    Page<Organization> getOrganizationsWithFilter(PageRequest page, String name, Set<Sector> sector,
//                                                  Set<SubSector> subSector );
//
//    Page<Organization> getOrganizationWithName( PageRequest page, String name );
//
//    Page<Organization> getOrganizationWithSectorID( PageRequest page, Set<Sector> sector );
//
//    Page<Organization> getOrganizationWithNameAndSectorID( PageRequest page, String name, Set<Sector> sector );
//
//    Page<Organization> getOrganizationWithSubSectorId( PageRequest page, Set<SubSector> subSector );
//
//    Page<Organization> getOrganizationWithNameAndSubSectorId( PageRequest page, String name, Set<SubSector> subSector );
//
//    Page<Organization> getOrganizationWithSectorIDAndSubSectorId( PageRequest page, Set<Sector> sector,
//                                                                  Set<SubSector> subSector );
//
//    Page<Organization> findAllByNameIgnoreCaseContainingAndSectorsInAndSubSectorsIn(Pageable pageable, String name,
//                                                                                    Set<Sector> sectors, Set<SubSector> subSectors );
//
//    Page<Organization> findByNameIgnoreCaseContaining( Pageable pageable, String name );
//
//    Page<Organization> findBySectorsIn( Pageable pageable, Set<Sector> sectors );
//
//    Page<Organization> findByNameIgnoreCaseContainingAndSectorsIn( Pageable pageable, String name, Set<Sector> sectors );
//
//    Page<Organization> findBySubSectorsIn( Pageable pageable, Set<SubSector> subSectors );
//
//    Page<Organization> findByNameIgnoreCaseContainingAndSubSectorsIn( Pageable pageable, String name,
//                                                                      Set<SubSector> subSectors );
//
//    Page<Organization> findBySectorsInAndSubSectorsIn( Pageable pageable, Set<Sector> sectors,
//                                                       Set<SubSector> subSectors );
//Optional<SubSector> getBySubSectorId( UUID subSectorId );
//@Override
//public Optional<SubSector> getBySubSectorId( final UUID subSectorId ) {
//        return subSectorRepository.findById( subSectorId );
//        }
//}
