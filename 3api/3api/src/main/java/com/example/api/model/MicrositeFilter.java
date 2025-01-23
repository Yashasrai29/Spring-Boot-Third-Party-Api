package com.example.api.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MicrositeFilter {/*
    @GetMapping( "/microsite-filters" )
    public ResponseEntity<PaginationOutput<MicrositeProfileOutput>> getMicrositesByFilter(
            @RequestParam( name = "organizationName", required = false ) String name,
            @RequestParam( name = "sectorIds", required = false ) String sectorIds,
            @RequestParam( name = "subSectorIds", required = false ) String subSectorIds,
            @RequestParam( required = false, defaultValue = PAGE_NUMBER ) String pageNumber,
            @RequestParam( required = false, defaultValue = PAGE_SIZE ) String pageSize,
            @RequestParam( name = "size", required = false ) String size ) {
        return new ResponseEntity<>(
                organizationFacade.getMicrositeQuery( name, sectorIds, subSectorIds, pageNumber, pageSize, size ),
                HttpStatus.OK );
    }
    PaginationOutput<MicrositeProfileOutput> getMicrositeQuery( String name, String sectorId, String subSectorId,
      String pageNumber, String pageSize, String size );

       @Override
  public PaginationOutput<MicrositeProfileOutput> getMicrositeQuery( final String name, final String sectorId,
      final String subSectorId, final String pageNumber, final String pageSize, final String size ) {

    PageRequest page = PageRequest.of( Integer.parseInt( pageNumber ), Integer.parseInt( pageSize ) );
    UUID sectorValid = null;
    UUID subSectorValid = null;

    if( sectorId != null ) {
      sectorValid = UUID.fromString( sectorId );
    } else {
      //sectorValid = UUID.fromString( "00000000-0000-0000-0000-000000000000" );
      sectorValid = null;
    }
    if( subSectorId != null ) {
      subSectorValid = UUID.fromString( subSectorId );
    } else {
      //subSectorValid = UUID.fromString( "00000000-0000-0000-0000-000000000000" );
      subSectorValid = null;
    }

    var microsites = organizationService.getMicrosite( name, sectorValid, subSectorValid, size, page );

    return PageMapper.INSTANCE.response( microsites,
        microsites.stream().map( MicrositeMapper.INSTANCE::mapModelToDto ).toList() );

  }
   Page<Microsite> getMicrosite( String name, UUID sectorId, UUID subSectorId, String size, PageRequest page );

   @Override
  public Page<Microsite> getMicrosite( final String name, final UUID sectorId, final UUID subSectorId,
      final String size, final PageRequest page ) {
    return micrositeRepository.findByMicrositeFilter( name, sectorId, subSectorId, size, page );
  }

  @Query( value = "select * from microsite m where m.organization_id in( select o.id from " + "organization as o "
      + "inner " + "join " + "organization_sectors as os on o" + ".id=os" + ".organization_id inner" + " join " +
      "organization_sub_sectors " + "as " + "oss" + " " + "on o.id=oss.organization_id inner " + "join " + "sector "
      + "as" + " s on s.id=os" + ".sectors_id " + "inner join" + " " + "sub_sector as ss on ss.id=oss.sub_sectors_id "
      + "where ( :name is null" + " or  o.name=:name" + " " + ") and ( " + ":sectorId  is " + "null or s.id=:sectorId"
      + " ) and ( " + ":subSectorId is null or ss" + ".id" + "=:subSectorId ) " + "and ( " + ":size is null or  o" +
      ".size" + "=:size ))  ", nativeQuery = true )
  Page<Microsite> findByMicrositeFilter( String name, UUID sectorId, UUID subSectorId, String size, Pageable pageable );
*/}
