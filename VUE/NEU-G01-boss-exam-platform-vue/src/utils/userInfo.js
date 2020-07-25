import Cookies from 'js-cookie'

const UserId = 'UserId'
const CompanyId = 'CompanyId'
const OrganizationId = 'OrganizationId'


export function getUserId() {
  return Cookies.get(UserId) === "null" ? null : Cookies.get(UserId)
}

export function setUserId(userId) {
  return Cookies.set(UserId, userId)
}

export function removeUserId() {
  return Cookies.remove(UserId)
}

export function getCompanyId() {
  return Cookies.get(CompanyId) === "null" ? null : Cookies.get(CompanyId)
}

export function setCompanyId(companyId) {
  return Cookies.set(CompanyId, companyId)
}

export function removeCompanyId() {
  return Cookies.remove(CompanyId)
}

export function getOrganizationId() {
  return Cookies.get(OrganizationId) === "null" ? null : Cookies.get(OrganizationId)
}

export function setOrganizationId(organizationId) {
  return Cookies.set(OrganizationId, organizationId)
}

export function removeOrganizationId() {
  return Cookies.remove(OrganizationId)
}
