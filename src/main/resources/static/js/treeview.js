function drawTreeView(data) {
  $("#tree-view").bstreeview({
    data,
  })
}

function findNodesById(nodes, targetId) {
  for (let i = 0; i < nodes.length; i++) {
    const currentNode = nodes[i]

    if (currentNode.id === targetId) {
      // 특정 id 값을 가진 노드를 찾으면 해당 노드의 nodes 값을 반환
      return currentNode.nodes
    }
    if (currentNode.nodes && currentNode.nodes.length > 0) {
      // 현재 노드에 하위 노드가 있다면 재귀적으로 검색
      const nestedNodes = findNodesById(currentNode.nodes, targetId)
      if (nestedNodes) {
        return nestedNodes // 하위 노드에서 찾았으면 반환
      }
    }
  }

  // 해당 id를 찾지 못했을 경우
  return null
}

function loadUserData(targetId) {
  $.ajax({
    url: `/api/users/${targetId}`,
    type: "GET",
    dataType: "json",
  })
    .done((data) => {
      // table 비우기
      $("#dataTable thead").empty()
      $("#dataTable thead").append(
        "<th>" +
          '<input type="checkbox" />' +
          "</th>" +
          "<th>조직ID</th>" +
          "<th>Name</th>" +
          "<th>e-mail</th>" +
          "<th>생성일</th>",
      )

      $("#dataTable tbody").empty()
      // table 채우기
      for (let i = 0; i < data.length; i++) {
        const user = data[i]
        $("#dataTable tbody").append(
          "<tr>" +
            '<td><input type="checkbox"></td>' +
            `<td>${user.organizationId}</td>` +
            `<td>${user.username}</td>` +
            `<td>${user.email}</td>` +
            `<td>${user.createdAt}</td>` +
            "</tr>",
        )
      }
    })
    .fail(() => {
      alert("User Data Error!")
    })
}

function addClickEvent(data) {
  $(".list-group-item").on("click", function () {
    const nodes = findNodesById(data, this.id)
    if (nodes === null) {
      loadUserData(this.id)
    }
  })
}

function initializeTreeView() {
  $.ajax({
    url: "/api/tree/1",
    type: "GET",
    dataType: "json",
  })
    .done((data) => {
      drawTreeView(data)
      addClickEvent(data)
    })
    .fail(() => {
      alert("Tree Data Error!")
    })
}

$(document).ready(() => {
  initializeTreeView()
})
